package com.ismt.cybersecurity.utils;

/**
 * a model class. It will help in capturing captcha response.
 * @author brody
 *
 */
public class CaptchaResponse {
	
	private boolean success;
	private String challengeTs;
	private String hostname;
	
	
	
	public CaptchaResponse(boolean success, String challengeTs, String hostname) {

		this.success = success;
		this.challengeTs = challengeTs;
		this.hostname = hostname;
	}

	public CaptchaResponse() {
		super();
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getChallengeTs() {
		return challengeTs;
	}
	public void setChallengeTs(String challengeTs) {
		this.challengeTs = challengeTs;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	
	@Override
	public String toString() {
		return "CaptchaResponse [success=" + success + ", challengeTs=" + challengeTs + ", hostname=" + hostname + "]";
	}

}
