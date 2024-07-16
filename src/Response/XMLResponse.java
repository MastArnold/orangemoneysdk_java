/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Response;

import org.json.JSONObject;
import org.json.XML;

public class XMLResponse {
    public static JSONObject parse(String xmlContent) {
        return XML.toJSONObject(xmlContent);
    }
}
