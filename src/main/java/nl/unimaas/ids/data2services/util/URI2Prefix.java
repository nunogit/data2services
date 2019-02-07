/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.unimaas.ids.data2services.util;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import nl.unimaas.ids.rdf2api.io.utils.FileReader;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author nuno
 */
public class URI2Prefix {

    private static Map<String, String> uriToPrefix;
    private static Map<String, String> prefixToUri;

    static {
        URI2Prefix.prefixToUri = new HashMap<String, String>();
        URI2Prefix.uriToPrefix = new HashMap<String, String>();

        FileReader fileReader = new FileReader("prefixtable.tsv");
        String fileContent = fileReader.read();
        String str[] = fileContent.split("\n");

        for (int i = 1; i < str.length; i++) {
            String arr[] = str[i].split("\t");
            URI2Prefix.prefixToUri.put(arr[0], arr[1]);
            URI2Prefix.uriToPrefix.put(arr[1], arr[0]);
        }
    }

    //TODO discuss with Vincent about a better naming
    public static String uriToPrefix(String uri) {
        return URI2Prefix.uriToPrefix.get(uri);
    }

    public static String prefixToUri(String prefix) {
        String domain;
        String id;
        
        if (prefix.contains(":")) {
            String[] data;
            data = prefix.split(":");
            domain = data[0];
            id = data[1];
        } else {
            domain = prefix;
            id = "";
        }
        return URI2Prefix.prefixToUri.get(domain) + id;
    }

}
