package com.baidu.ueditor.upload;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.baidu.ueditor.PathFormat;
import com.baidu.ueditor.define.AppInfo;
import com.baidu.ueditor.define.BaseState;
import com.baidu.ueditor.define.FileType;
import com.baidu.ueditor.define.State;
import com.oss.OSSConfigure;
import com.oss.OSSManageUtil;

public class BinaryUploader {

	public static final State save(HttpServletRequest request,
			Map<String, Object> conf) {
		MultipartFile fileStream = null;
		boolean isAjaxUpload = request.getHeader( "X_Requested_With" ) != null;

		if (!ServletFileUpload.isMultipartContent(request)) {
			return new BaseState(false, AppInfo.NOT_MULTIPART_CONTENT);
		}

		ServletFileUpload upload = new ServletFileUpload(
				new DiskFileItemFactory());

        if ( isAjaxUpload ) {
            upload.setHeaderEncoding( "UTF-8" );
        }

		try {
//			FileItemIterator iterator = upload.getItemIterator(request);
//
//			while (iterator.hasNext()) {
//				fileStream = iterator.next();
//
//				if (!fileStream.isFormField())
//					break;
//				fileStream = null;
//			}
			
			if (fileStream == null) {
				List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles(conf.get("fieldName").toString());
				
				for(MultipartFile f : files){
					fileStream = f;

					if (!fileStream.isEmpty())
						break;
					fileStream = null;
				}
			}

			if (fileStream == null) {
				return new BaseState(false, AppInfo.NOTFOUND_UPLOAD_DATA);
			}

			String savePath = (String) conf.get("savePath");
			String originFileName = fileStream.getOriginalFilename();
			String suffix = FileType.getSuffixByFilename(originFileName);

			originFileName = originFileName.substring(0,
					originFileName.length() - suffix.length());
			savePath = savePath + suffix;

			long maxSize = ((Long) conf.get("maxSize")).longValue();

			if (!validType(suffix, (String[]) conf.get("allowFiles"))) {
				return new BaseState(false, AppInfo.NOT_ALLOW_FILE_TYPE);
			}

			savePath = PathFormat.parse(savePath, originFileName);

			String physicalPath = (String) conf.get("rootPath") + savePath;

			OSSConfigure ossConfigure = (OSSConfigure)conf.get("OSSConfigure");
			String ossPath = OSSManageUtil.uploadFile(ossConfigure,fileStream, savePath);
			
//			InputStream is = fileStream.getInputStream();
//			State storageState = StorageManager.saveFileByInputStream(is,
//					physicalPath, maxSize);
//			is.close();
			
			State storageState = new BaseState(true);
			
			if (storageState.isSuccess()) {
				storageState.putInfo("url", ossPath);
				storageState.putInfo("type", suffix);
				storageState.putInfo("original", originFileName + suffix);
			}

			return storageState;
		} catch (IOException e) {
			return new BaseState(false, AppInfo.PARSE_REQUEST_ERROR);
		} catch (Exception e) {
			return new BaseState(false, AppInfo.PARSE_REQUEST_ERROR);
		}
//		return new BaseState(false, AppInfo.IO_ERROR);
	}

	private static boolean validType(String type, String[] allowTypes) {
		List<String> list = Arrays.asList(allowTypes);

		return list.contains(type);
	}
}
