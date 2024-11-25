/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GerarArquivos;
import com.mycompany.cadconempregadojfx.Empregado;
import com.mycompany.cadconempregadojfx.Executivo;
import com.mycompany.cadconempregadojfx.Gerente;
import com.mycompany.cadconempregadojfx.Programador;
import com.mycompany.cadconempregadojfx.Secretario;
import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/**
 *
 * @author joaog
 */
public class Xml {
    private String arquivo;
    
    public void setarquivo(String nome){
        this.arquivo=("Arquivos\\XML\\"+nome+".xml");
    }
    public String getarquivo(){
        return this.arquivo;
    }

    public void CriarAquivo(ArrayList alemp, ArrayList alger, ArrayList alsec, ArrayList alprog, ArrayList alex){
        try{
            Empregado emp;
            Gerente g;
            Secretario s;
            Programador p;
            Executivo ex;
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder dc = dbf.newDocumentBuilder();
            Document d = dc.newDocument();
            
            Element raiz = d.createElement("Posts");
            d.appendChild(raiz);
            for(int i=0;i<alemp.size();i++){
                emp=(Empregado) alemp.get(i);
                
                Element post = d.createElement("Empregado");
                raiz.appendChild(post);
            
                Attr attr = d.createAttribute("id");
                long currentTimeStamp = System.currentTimeMillis();
                attr.setValue(""+currentTimeStamp);
                post.setAttributeNode(attr);
            
                Element textoRecebido1 = d.createElement("Nome");
                textoRecebido1.appendChild(d.createTextNode(emp.getNome()));
                post.appendChild(textoRecebido1);
            
                Element textoRecebido2 = d.createElement("Salario");
                textoRecebido2.appendChild(d.createTextNode(""+emp.getSalario()));
                post.appendChild(textoRecebido2);
            
                Element textoRecebido3 = d.createElement("DataContratacao");
                textoRecebido3.appendChild(d.createTextNode(emp.getDataContratacao()));
                post.appendChild(textoRecebido3);
            }
            
            for(int i=0;i<alger.size();i++){
                g=(Gerente) alger.get(i);
                
                Element post = d.createElement("Gerente");
                raiz.appendChild(post);
            
                Attr attr = d.createAttribute("id");
                long currentTimeStamp = System.currentTimeMillis();
                attr.setValue(""+currentTimeStamp);
                post.setAttributeNode(attr);
            
                Element textoRecebido1 = d.createElement("Nome");
                textoRecebido1.appendChild(d.createTextNode(g.getNome()));
                post.appendChild(textoRecebido1);
            
                Element textoRecebido2 = d.createElement("Salario");
                textoRecebido2.appendChild(d.createTextNode(""+g.getSalario()));
                post.appendChild(textoRecebido2);
            
                Element textoRecebido3 = d.createElement("DataContratacao");
                textoRecebido3.appendChild(d.createTextNode(g.getDataContratacao()));
                post.appendChild(textoRecebido3);
            }
            
            for(int i=0;i<alsec.size();i++){
                s = (Secretario) alsec.get(i);
                
                Element post = d.createElement("Secretario");
                raiz.appendChild(post);
            
                Attr attr = d.createAttribute("id");
                long currentTimeStamp = System.currentTimeMillis();
                attr.setValue(""+currentTimeStamp);
                post.setAttributeNode(attr);
            
                Element textoRecebido1 = d.createElement("Nome");
                textoRecebido1.appendChild(d.createTextNode(s.getNome()));
                post.appendChild(textoRecebido1);
            
                Element textoRecebido2 = d.createElement("Salario");
                textoRecebido2.appendChild(d.createTextNode(""+s.getSalario()));
                post.appendChild(textoRecebido2);
            
                Element textoRecebido3 = d.createElement("DataContratacao");
                textoRecebido3.appendChild(d.createTextNode(s.getDataContratacao()));
                post.appendChild(textoRecebido3);
                
                Element textoRecebido4 = d.createElement("Turno");
                textoRecebido4.appendChild(d.createTextNode(s.getTurno()));
                post.appendChild(textoRecebido4);
            }
            
            for(int i=0;i<alprog.size();i++){
                p = (Programador) alprog.get(i);
                
                Element post = d.createElement("Programador");
                raiz.appendChild(post);
            
                Attr attr = d.createAttribute("id");
                long currentTimeStamp = System.currentTimeMillis();
                attr.setValue(""+currentTimeStamp);
                post.setAttributeNode(attr);
            
                Element textoRecebido1 = d.createElement("Nome");
                textoRecebido1.appendChild(d.createTextNode(p.getNome()));
                post.appendChild(textoRecebido1);
            
                Element textoRecebido2 = d.createElement("Salario");
                textoRecebido2.appendChild(d.createTextNode(""+p.getSalario()));
                post.appendChild(textoRecebido2);
            
                Element textoRecebido3 = d.createElement("DataContratacao");
                textoRecebido3.appendChild(d.createTextNode(p.getDataContratacao()));
                post.appendChild(textoRecebido3);
                
                Element textoRecebido4 = d.createElement("Area");
                textoRecebido4.appendChild(d.createTextNode(p.getAreaProg()));
                post.appendChild(textoRecebido4);
            }
            
            for(int i=0;i<alex.size();i++){
                ex = (Executivo) alex.get(i);
                
                Element post = d.createElement("Executivo");
                raiz.appendChild(post);
            
                Attr attr = d.createAttribute("id");
                long currentTimeStamp = System.currentTimeMillis();
                attr.setValue(""+currentTimeStamp);
                post.setAttributeNode(attr);
            
                Element textoRecebido1 = d.createElement("Nome");
                textoRecebido1.appendChild(d.createTextNode(ex.getNome()));
                post.appendChild(textoRecebido1);
            
                Element textoRecebido2 = d.createElement("Salario");
                textoRecebido2.appendChild(d.createTextNode(""+ex.getSalario()));
                post.appendChild(textoRecebido2);
            
                Element textoRecebido3 = d.createElement("DataContratacao");
                textoRecebido3.appendChild(d.createTextNode(ex.getDataContratacao()));
                post.appendChild(textoRecebido3);
            }
            
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            DOMSource domSource = new DOMSource(d);
            StreamResult streamResult = new StreamResult(arquivo);
            t.transform(domSource, streamResult);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public ArrayList LerArquivoEmp(){
        try{
            File arquivoXMLEm = new File(arquivo);
            if(arquivoXMLEm.exists()){
                ArrayList<Empregado> al = new ArrayList<>();
                DocumentBuilderFactory dbfEm = DocumentBuilderFactory.newInstance();
                DocumentBuilder dbEm = dbfEm.newDocumentBuilder();
                Document dEm = dbEm.parse(arquivoXMLEm);
                dEm.getDocumentElement().normalize();
                NodeList nodeListEm = dEm.getElementsByTagName("Empregado"); 
                for (int itr = 0; itr < nodeListEm.getLength(); itr++){  
                    Node node = nodeListEm.item(itr);
                    if (node.getNodeType() == Node.ELEMENT_NODE){
                        Element eElement = (Element) node;
                        Empregado emp = new Empregado(eElement.getElementsByTagName("Nome").item(0).getTextContent(),Double.parseDouble(eElement.getElementsByTagName("Salario").item(0).getTextContent()),eElement.getElementsByTagName("DataContratacao").item(0).getTextContent());
                        al.add(emp);
                    }
                }
                return al;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList LerArquivoGer(){
        try{
            File arquivoXMLEm = new File(arquivo);
            if(arquivoXMLEm.exists()){
                ArrayList<Gerente> al = new ArrayList<>();
                DocumentBuilderFactory dbfEm = DocumentBuilderFactory.newInstance();
                DocumentBuilder dbEm = dbfEm.newDocumentBuilder();
                Document dEm = dbEm.parse(arquivoXMLEm);
                dEm.getDocumentElement().normalize();
                NodeList nodeListEm = dEm.getElementsByTagName("Gerente"); 
                for (int itr = 0; itr < nodeListEm.getLength(); itr++){  
                    Node node = nodeListEm.item(itr);
                    if (node.getNodeType() == Node.ELEMENT_NODE){
                        Element eElement = (Element) node;
                        Gerente ger = new Gerente(eElement.getElementsByTagName("Nome").item(0).getTextContent(),Double.parseDouble(eElement.getElementsByTagName("Salario").item(0).getTextContent()),eElement.getElementsByTagName("DataContratacao").item(0).getTextContent());
                        al.add(ger);
                    }
                }
                return al;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList LerArquivoSec(){
        try{
            File arquivoXMLEm = new File(arquivo);
            if(arquivoXMLEm.exists()){
                ArrayList<Secretario> al = new ArrayList<>();
                DocumentBuilderFactory dbfEm = DocumentBuilderFactory.newInstance();
                DocumentBuilder dbEm = dbfEm.newDocumentBuilder();
                Document dEm = dbEm.parse(arquivoXMLEm);
                dEm.getDocumentElement().normalize();
                NodeList nodeListEm = dEm.getElementsByTagName("Secretario"); 
                for (int itr = 0; itr < nodeListEm.getLength(); itr++){  
                    Node node = nodeListEm.item(itr);
                    if (node.getNodeType() == Node.ELEMENT_NODE){
                        Element eElement = (Element) node;
                        Secretario sec = new Secretario(eElement.getElementsByTagName("Nome").item(0).getTextContent(),Double.parseDouble(eElement.getElementsByTagName("Salario").item(0).getTextContent()),eElement.getElementsByTagName("DataContratacao").item(0).getTextContent(),eElement.getElementsByTagName("Turno").item(0).getTextContent());
                        al.add(sec);
                    }
                }
                return al;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList LerArquivoProg(){
        try{
            File arquivoXMLEm = new File(arquivo);
            if(arquivoXMLEm.exists()){
                ArrayList<Programador> al = new ArrayList<>();
                DocumentBuilderFactory dbfEm = DocumentBuilderFactory.newInstance();
                DocumentBuilder dbEm = dbfEm.newDocumentBuilder();
                Document dEm = dbEm.parse(arquivoXMLEm);
                dEm.getDocumentElement().normalize();
                NodeList nodeListEm = dEm.getElementsByTagName("Programador"); 
                for (int itr = 0; itr < nodeListEm.getLength(); itr++){  
                    Node node = nodeListEm.item(itr);
                    if (node.getNodeType() == Node.ELEMENT_NODE){
                        Element eElement = (Element) node;
                        Programador prog = new Programador(eElement.getElementsByTagName("Nome").item(0).getTextContent(),Double.parseDouble(eElement.getElementsByTagName("Salario").item(0).getTextContent()),eElement.getElementsByTagName("DataContratacao").item(0).getTextContent(),eElement.getElementsByTagName("Area").item(0).getTextContent());
                        al.add(prog);
                    }
                }
                return al;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList LerArquivoEx(){
        try{
            File arquivoXMLEm = new File(arquivo);
            if(arquivoXMLEm.exists()){
                ArrayList<Executivo> al = new ArrayList<>();
                DocumentBuilderFactory dbfEm = DocumentBuilderFactory.newInstance();
                DocumentBuilder dbEm = dbfEm.newDocumentBuilder();
                Document dEm = dbEm.parse(arquivoXMLEm);
                dEm.getDocumentElement().normalize();
                NodeList nodeListEm = dEm.getElementsByTagName("Executivo"); 
                for (int itr = 0; itr < nodeListEm.getLength(); itr++){  
                    Node node = nodeListEm.item(itr);
                    if (node.getNodeType() == Node.ELEMENT_NODE){
                        Element eElement = (Element) node;
                        Executivo ex = new Executivo(eElement.getElementsByTagName("Nome").item(0).getTextContent(),Double.parseDouble(eElement.getElementsByTagName("Salario").item(0).getTextContent()),eElement.getElementsByTagName("DataContratacao").item(0).getTextContent());
                        al.add(ex);
                    }
                }
                return al;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
