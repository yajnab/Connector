/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connector;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author yajnavalkya
 */
public class Connector {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception{
        WebClient webClient = new WebClient(BrowserVersion.FIREFOX_38); //Initiate a WebClient variable.   
        webClient = login(webClient);
    }
    private static WebClient login(WebClient webClient) throws Exception
    {
        webClient.getOptions().setJavaScriptEnabled(false);    
        final HtmlPage currentPage = webClient.getPage("http://10.254.254.17/0/up/"); //Load Alliance Broadband Login Page
        final  HtmlInput username = (HtmlInput) currentPage.getElementById("username");
        username.setValueAttribute("yb_tc"); //Set value for username       
        final  HtmlInput password = (HtmlInput) currentPage.getElementById("password"); //Find element called loginpassword for password
        System.out.println("Enter Password");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String passd = in.readLine();
        password.setValueAttribute(passd); //Set value for password   
        WebResponse response1 = currentPage.getWebResponse();
        String content2 = response1.getContentAsString();    
        final HtmlPage page2; 
        HtmlElement htmlElement = currentPage.getFirstByXPath("//*[@name=\"login\"]");
        HtmlPage src=htmlElement.click();       
        return webClient;
    }

    }
   
