/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.unimaas.ids.data2services.util.iface;

import java.net.URL;
import java.util.List;

/**
 *
 * @author nuno
 */
public interface ReadEntities {
    public void setSource(URL url);
    public List<String> getEntities();
}