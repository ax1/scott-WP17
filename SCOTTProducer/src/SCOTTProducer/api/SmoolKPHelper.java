
/*
 * Generated Smool KP helper
 */
package SCOTTProducer.api;


import SCOTTProducer.model.smoolcore.*;
import SCOTTProducer.model.smoolcore.impl.*;

public abstract class SmoolKPHelper {

	// Helpers for Leaf class Alarm
	public static IAlarm createAlarm (String alarmDescription, String alarmSeverity, String dataID, String timestamp) {
		return createAlarm("", alarmDescription, alarmSeverity, dataID, timestamp);
	}

	public static IAlarm createAlarm (String elemID, String alarmDescription, String alarmSeverity, String dataID, String timestamp) {
		Alarm token = new Alarm();

		if (elemID != null && !elemID.equals("")) {
			token._setIndividualID(elemID);
		}
		
		token.setAlarmDescription(alarmDescription);
		token.setAlarmSeverity(alarmSeverity);
		token.setDataID(dataID);
		token.setTimestamp(timestamp);
		return token;
	}

	// Helper for subclass class
	public static IEmailAddress createEmailAddressLogicalLocation (String elemID, String dataID, String email, String timestamp, ILogicalLocation logicalLoc) {
		EmailAddress token = new EmailAddress();

		if (elemID != null && !elemID.equals("")) {
			token._setIndividualID(elemID);
		}

		token.setDataID(dataID);
		token.setEmail(email);
		token.setTimestamp(timestamp);
		token.setLogicalLoc(logicalLoc);
		return token;
	}

	// Helper for subclass class
	public static IFacebookAccount createFacebookAccountLogicalLocation (String elemID, String dataID, String password, String timestamp, String username, ILogicalLocation logicalLoc) {
		FacebookAccount token = new FacebookAccount();

		if (elemID != null && !elemID.equals("")) {
			token._setIndividualID(elemID);
		}

		token.setDataID(dataID);
		token.setPassword(password);
		token.setTimestamp(timestamp);
		token.setUsername(username);
		token.setLogicalLoc(logicalLoc);
		return token;
	}

	// Helper for subclass class
	public static ITwitterAccount createTwitterAccountLogicalLocation (String elemID, String dataID, String password, String timestamp, String username, ILogicalLocation logicalLoc) {
		TwitterAccount token = new TwitterAccount();

		if (elemID != null && !elemID.equals("")) {
			token._setIndividualID(elemID);
		}

		token.setDataID(dataID);
		token.setPassword(password);
		token.setTimestamp(timestamp);
		token.setUsername(username);
		token.setLogicalLoc(logicalLoc);
		return token;
	}

	// Helper for subclass class
	public static IWhatsAppAccount createWhatsAppAccountLogicalLocation (String elemID, String dataID, String password, String timestamp, String username, ILogicalLocation logicalLoc) {
		WhatsAppAccount token = new WhatsAppAccount();

		if (elemID != null && !elemID.equals("")) {
			token._setIndividualID(elemID);
		}

		token.setDataID(dataID);
		token.setPassword(password);
		token.setTimestamp(timestamp);
		token.setUsername(username);
		token.setLogicalLoc(logicalLoc);
		return token;
	}

	// Helper for subclass class
	public static IIP4Address createIP4AddressLogicalLocation (String elemID, String dataID, String timestamp, ILogicalLocation logicalLoc) {
		IP4Address token = new IP4Address();

		if (elemID != null && !elemID.equals("")) {
			token._setIndividualID(elemID);
		}

		token.setDataID(dataID);
		token.setTimestamp(timestamp);
		token.setLogicalLoc(logicalLoc);
		return token;
	}

	// Helper for subclass class
	public static IIP6Address createIP6AddressLogicalLocation (String elemID, String dataID, String timestamp, ILogicalLocation logicalLoc) {
		IP6Address token = new IP6Address();

		if (elemID != null && !elemID.equals("")) {
			token._setIndividualID(elemID);
		}

		token.setDataID(dataID);
		token.setTimestamp(timestamp);
		token.setLogicalLoc(logicalLoc);
		return token;
	}

	// Helper for subclass class
	public static ITelephoneNumber createTelephoneNumberLogicalLocation (String elemID, String dataID, String number, String timestamp, ILogicalLocation logicalLoc) {
		TelephoneNumber token = new TelephoneNumber();

		if (elemID != null && !elemID.equals("")) {
			token._setIndividualID(elemID);
		}

		token.setDataID(dataID);
		token.setNumber(number);
		token.setTimestamp(timestamp);
		token.setLogicalLoc(logicalLoc);
		return token;
	}

	// Helper for subclass class
	public static IEmailMessage createEmailMessageMessage (String elemID, String body, String dataID, String subject, String timestamp) {
		EmailMessage token = new EmailMessage();

		if (elemID != null && !elemID.equals("")) {
			token._setIndividualID(elemID);
		}

		token.setBody(body);
		token.setDataID(dataID);
		token.setSubject(subject);
		token.setTimestamp(timestamp);
		return token;
	}

	// Helper for subclass class
	public static ISecurityAuthentication createSecurityAuthenticationSecurity (String elemID, String data, String dataID, String timestamp, String type) {
		SecurityAuthentication token = new SecurityAuthentication();

		if (elemID != null && !elemID.equals("")) {
			token._setIndividualID(elemID);
		}

		token.setData(data);
		token.setDataID(dataID);
		token.setTimestamp(timestamp);
		token.setType(type);
		return token;
	}

	// Helper for subclass class
	public static ISecurityAuthorization createSecurityAuthorizationSecurity (String elemID, String data, String dataID, String timestamp, String type) {
		SecurityAuthorization token = new SecurityAuthorization();

		if (elemID != null && !elemID.equals("")) {
			token._setIndividualID(elemID);
		}

		token.setData(data);
		token.setDataID(dataID);
		token.setTimestamp(timestamp);
		token.setType(type);
		return token;
	}

	// Helper for subclass class
	public static ISecurityConfidentiality createSecurityConfidentialitySecurity (String elemID, String data, String dataID, String timestamp, String type) {
		SecurityConfidentiality token = new SecurityConfidentiality();

		if (elemID != null && !elemID.equals("")) {
			token._setIndividualID(elemID);
		}

		token.setData(data);
		token.setDataID(dataID);
		token.setTimestamp(timestamp);
		token.setType(type);
		return token;
	}

	// Helper for subclass class
	public static ISecurityIntegrity createSecurityIntegritySecurity (String elemID, String data, String dataID, String timestamp, String type) {
		SecurityIntegrity token = new SecurityIntegrity();

		if (elemID != null && !elemID.equals("")) {
			token._setIndividualID(elemID);
		}

		token.setData(data);
		token.setDataID(dataID);
		token.setTimestamp(timestamp);
		token.setType(type);
		return token;
	}

	// Helper for subclass class
	public static ISecurityNonRepudiation createSecurityNonRepudiationSecurity (String elemID, String data, String dataID, String timestamp, String type) {
		SecurityNonRepudiation token = new SecurityNonRepudiation();

		if (elemID != null && !elemID.equals("")) {
			token._setIndividualID(elemID);
		}

		token.setData(data);
		token.setDataID(dataID);
		token.setTimestamp(timestamp);
		token.setType(type);
		return token;
	}

	// Helper for subclass class
	public static IGisLocation createGisLocationPhysicalLocation (String elemID, String dataID, Double latitude, Double longitude, String timestamp) {
		GisLocation token = new GisLocation();

		if (elemID != null && !elemID.equals("")) {
			token._setIndividualID(elemID);
		}

		token.setDataID(dataID);
		token.setLatitude(latitude);
		token.setLongitude(longitude);
		token.setTimestamp(timestamp);
		return token;
	}

	// Helper for subclass class
	public static ILocation2D createLocation2DPhysicalLocation (String elemID, String dataID, String timestamp, Double x, Double y) {
		Location2D token = new Location2D();

		if (elemID != null && !elemID.equals("")) {
			token._setIndividualID(elemID);
		}

		token.setDataID(dataID);
		token.setTimestamp(timestamp);
		token.setX(x);
		token.setY(y);
		return token;
	}

	// Helper for subclass class
	public static ILocation3D createLocation3DPhysicalLocation (String elemID, String dataID, String timestamp, Double x, Double y, Double z) {
		Location3D token = new Location3D();

		if (elemID != null && !elemID.equals("")) {
			token._setIndividualID(elemID);
		}

		token.setDataID(dataID);
		token.setTimestamp(timestamp);
		token.setX(x);
		token.setY(y);
		token.setZ(z);
		return token;
	}

	// Helpers for Leaf class PresenceInformation
	public static IPresenceInformation createPresenceInformation (String dataID, Boolean status, String timestamp) {
		return createPresenceInformation("", dataID, status, timestamp);
	}

	public static IPresenceInformation createPresenceInformation (String elemID, String dataID, Boolean status, String timestamp) {
		PresenceInformation token = new PresenceInformation();

		if (elemID != null && !elemID.equals("")) {
			token._setIndividualID(elemID);
		}
		
		token.setDataID(dataID);
		token.setStatus(status);
		token.setTimestamp(timestamp);
		return token;
	}


}
