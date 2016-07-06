package com.oss;

import org.springframework.boot.context.properties.ConfigurationProperties;
  
@ConfigurationProperties(prefix = "oss") 
public class OSSConfigure {  
  
    private String endpoint;  
    private String accessKeyId;  
    private String accessKeySecret;  
    private String bucketName;  
    private String accessUrl;
    private String dir;

	public String getEndpoint() {  
        return endpoint;  
    }  
  
    public void setEndpoint(String endpoint) {  
        this.endpoint = endpoint;  
    }  
  
    public String getAccessKeyId() {  
        return accessKeyId;  
    }  
  
    public void setAccessKeyId(String accessKeyId) {  
        this.accessKeyId = accessKeyId;  
    }  
  
    public String getAccessKeySecret() {  
        return accessKeySecret;  
    }  
  
    public void setAccessKeySecret(String accessKeySecret) {  
        this.accessKeySecret = accessKeySecret;  
    }  
  
    public String getBucketName() {  
        return bucketName;  
    }  
  
    public void setBucketName(String bucketName) {  
        this.bucketName = bucketName;  
    }  
  
    public String getAccessUrl() {  
        return accessUrl;  
    }  
  
    public void setAccessUrl(String accessUrl) {  
        this.accessUrl = accessUrl;  
    }

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}
}  