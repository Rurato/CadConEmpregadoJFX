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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author joaog
 */
public class Json {
    private String arquivo;
    
    public void setarquivo(String nome){
        this.arquivo=("Arquivos\\Json\\"+nome+".json");
    }
    
    public void CriarAquivo(ArrayList alemp, ArrayList alger, ArrayList alsec, ArrayList alprog, ArrayList alex){
        Empregado emp;
        Gerente g;
        Secretario sec;
        Programador p;
        Executivo ex;
        JSONObject jsonObject = new JSONObject();
        FileWriter writeFile = null;
        for(int i=1;i<=alemp.size();i++){
            emp = (Empregado) alemp.get(i-1);
            jsonObject.put("idemp"+i+"nome", ""+emp.getNome());
            jsonObject.put("idemp"+i+"salario", ""+emp.getSalario());
            jsonObject.put("idemp"+i+"data", ""+emp.getDataContratacao());
        }
        for(int i=1;i<=alger.size();i++){
            g = (Gerente) alger.get(i-1);
            jsonObject.put("idger"+i+"nome", ""+g.getNome());
            jsonObject.put("idger"+i+"salario", ""+g.getSalario());
            jsonObject.put("idger"+i+"data", ""+g.getDataContratacao());
        }
        for(int i=1;i<=alsec.size();i++){
            sec = (Secretario) alsec.get(i-1);
            jsonObject.put("idsec"+i+"nome", ""+sec.getNome());
            jsonObject.put("idsec"+i+"salario", ""+sec.getSalario());
            jsonObject.put("idsec"+i+"data", ""+sec.getDataContratacao());
            jsonObject.put("idsec"+i+"turno", ""+sec.getTurno());
        }
        for(int i=1;i<=alprog.size();i++){
            p = (Programador) alprog.get(i-1);
            jsonObject.put("idprog"+i+"nome", ""+p.getNome());
            jsonObject.put("idprog"+i+"salario", ""+p.getSalario());
            jsonObject.put("idprog"+i+"data", ""+p.getDataContratacao());
            jsonObject.put("idprog"+i+"area", ""+p.getAreaProg());
        }
        for(int i=1;i<=alex.size();i++){
            ex = (Executivo) alex.get(i-1);
            jsonObject.put("idex"+i+"nome", ""+ex.getNome());
            jsonObject.put("idex"+i+"salario", ""+ex.getSalario());
            jsonObject.put("idex"+i+"data", ""+ex.getDataContratacao());
        }
        try{	
            writeFile = new FileWriter(arquivo);
            writeFile.write(jsonObject.toJSONString());
            writeFile.close();
        }
	catch(IOException e){
		e.printStackTrace();
	}
    }
    
    public ArrayList LerArquivoEmp(){
        JSONParser parser = new JSONParser();
	String nome;
	String salario;
	String data;
        int aux=0;
        ArrayList<Empregado> al = new ArrayList<>();
        JSONObject jsonObject = new JSONObject();
	try {
            jsonObject = (JSONObject) parser.parse(new FileReader(arquivo));
            for(int i=1;i<=jsonObject.size();i++){
                if(jsonObject.containsKey("idemp"+i+"nome")){
                    aux++;
                }
            }
            for (int i=1;i<=aux;i++){
                nome = (String) jsonObject.get("idemp"+i+"nome");
                salario = (String) jsonObject.get("idemp"+i+"salario");	
                data = (String) jsonObject.get("idemp"+i+"data");
                Empregado emp = new Empregado(nome,Double.parseDouble(salario),data);
                al.add(emp);
            }
            return al;
	}
	catch (FileNotFoundException e) {
		System.out.println("Arquivo não encontrado");
	}catch (IOException e) {
		e.printStackTrace();
	} catch (ParseException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public ArrayList LerArquivoGer(){
        JSONParser parser = new JSONParser();
	String nome;
	String salario;
	String data;
        ArrayList<Gerente> al = new ArrayList<>();
        JSONObject jsonObject = new JSONObject();
        int aux = 0;
	try {
            jsonObject = (JSONObject) parser.parse(new FileReader(arquivo));
            for(int i=1;i<=jsonObject.size();i++){
                if(jsonObject.containsKey("idger"+i+"nome")){
                    aux++;
                }
            }
            
            for (int i=1;i<=aux;i++){
                nome = (String) jsonObject.get("idger"+i+"nome");
                salario = (String) jsonObject.get("idger"+i+"salario");	
                data = (String) jsonObject.get("idger"+i+"data");
                Gerente ger = new Gerente(nome,Double.parseDouble(salario),data);
                al.add(ger);
            }
            return al;
	}
	catch (FileNotFoundException e) {
		System.out.println("Arquivo não encontrado");
	}catch (IOException e) {
		e.printStackTrace();
	} catch (ParseException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public ArrayList LerArquivoSec(){
        JSONParser parser = new JSONParser();
	String nome;
	String salario;
	String data;
        String turno;
        ArrayList<Secretario> al = new ArrayList<>();
        JSONObject jsonObject = new JSONObject();
        int aux=0;
	try {
            jsonObject = (JSONObject) parser.parse(new FileReader(arquivo));
            for(int i=1;i<=jsonObject.size();i++){
                if(jsonObject.containsKey("idsec"+i+"nome")){
                    aux++;
                }
            }
            for (int i=1;i<=aux;i++){
                nome = (String) jsonObject.get("idsec"+i+"nome");
                salario = (String) jsonObject.get("idsec"+i+"salario");	
                data = (String) jsonObject.get("idsec"+i+"data");
                turno = (String) jsonObject.get("idsec"+i+"turno");
                Secretario sec = new Secretario(nome,Double.parseDouble(salario),data,turno);
                al.add(sec);
            }
            return al;
	}
	catch (FileNotFoundException e) {
		System.out.println("Arquivo não encontrado");
	}catch (IOException e) {
		e.printStackTrace();
	} catch (ParseException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public ArrayList LerArquivoProg(){
        JSONParser parser = new JSONParser();
	String nome;
	String salario;
	String data;
        String area;
        ArrayList<Programador> al = new ArrayList<>();
        JSONObject jsonObject = new JSONObject();
        int aux=0;
	try {
            jsonObject = (JSONObject) parser.parse(new FileReader(arquivo));
            for(int i=1;i<=jsonObject.size();i++){
                if(jsonObject.containsKey("idprog"+i+"nome")){
                    aux++;
                }
            }
            for (int i=1;i<=aux;i++){
                nome = (String) jsonObject.get("idprog"+i+"nome");
                salario = (String) jsonObject.get("idprog"+i+"salario");	
                data = (String) jsonObject.get("idprog"+i+"data");
                area = (String) jsonObject.get("idprog"+i+"area");
                Programador prog = new Programador(nome,Double.parseDouble(salario),data,area);
                al.add(prog);
            }
            return al;
	}
	catch (FileNotFoundException e) {
		System.out.println("Arquivo não encontrado");
	}catch (IOException e) {
		e.printStackTrace();
	} catch (ParseException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public ArrayList LerArquivoEx(){
        JSONParser parser = new JSONParser();
	String nome;
	String salario;
	String data;
        ArrayList<Executivo> al = new ArrayList<>();
        JSONObject jsonObject = new JSONObject();
        int aux=0;
	try {
            jsonObject = (JSONObject) parser.parse(new FileReader(arquivo));
            for(int i=1;i<=jsonObject.size();i++){
                if(jsonObject.containsKey("idex"+i+"nome")){
                    aux++;
                }
            }
            for (int i=1;i<=aux;i++){
                nome = (String) jsonObject.get("idex"+i+"nome");
                salario = (String) jsonObject.get("idex"+i+"salario");	
                data = (String) jsonObject.get("idex"+i+"data");
                Executivo ex = new Executivo(nome,Double.parseDouble(salario),data);
                al.add(ex);
            }
            return al;
	}
	catch (FileNotFoundException e) {
		System.out.println("Arquivo não encontrado");
	}catch (IOException e) {
		e.printStackTrace();
	} catch (ParseException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
