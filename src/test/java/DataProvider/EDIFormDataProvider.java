package DataProvider;
import org.json.simple.JSONObject;
import utils.DataReader;

public class EDIFormDataProvider {
    public static JSONObject[] getEDIFormData() throws Exception {
        JSONObject json = DataReader.getEDIFormData("jsonfiles/ediFormData.json");

        JSONObject partnerContact = (JSONObject) json.get("PartnerContactInformation");
        JSONObject customerInfo = (JSONObject) json.get("CustomerInformation");
        JSONObject newCompany = (JSONObject) json.get("NewCompany");
        JSONObject benefitsInfo = (JSONObject) json.get("CustomerBenefitsInformation");
        JSONObject newCarrier = (JSONObject) json.get("NewCarrier");

        return new JSONObject[]{ partnerContact, customerInfo, newCompany, benefitsInfo, newCarrier };
    }
}
