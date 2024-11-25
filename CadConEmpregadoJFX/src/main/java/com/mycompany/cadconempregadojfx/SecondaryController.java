/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cadconempregadojfx;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author joaog
 */
public class SecondaryController {
    ArrayList<Empregado> EmpregadoList = new ArrayList<>();
    ArrayList<Gerente> GerenteList = new ArrayList<>();
    ArrayList<Secretario> SecretarioList = new ArrayList<>();
    ArrayList<Programador> ProgramadorList = new ArrayList<>();
    ArrayList<Executivo> ExecutivoList = new ArrayList<>();
    
    @FXML TextField NomeEmpre;
    @FXML TextField SalarioEmpre;
    @FXML TextField DataEmpre;
    @FXML ComboBox BoxEmpre1;
    @FXML ComboBox BoxEmpre2;
    @FXML TableView<Empregado> empregados;
    @FXML TableColumn<Empregado,String> tableNomeEmpre;
    @FXML TableColumn<Empregado,Double> tableSalarioEmpre;
    @FXML TableColumn<Empregado,String> tableDataEmpre;
    @FXML TextField AumentoSalarioEmpre;
    
    @FXML TextField NomeGeren;
    @FXML TextField SalarioGeren;
    @FXML TextField DataGeren;
    @FXML TextField BonusGeren;
    @FXML ComboBox BoxGeren1;
    @FXML ComboBox BoxGeren2;
    @FXML TableView<Gerente> gerentes;
    @FXML TableColumn<Gerente,String> tableNomeGeren;
    @FXML TableColumn<Gerente,Double> tableSalarioGeren;
    @FXML TableColumn<Gerente,String> tableDataGeren;
    @FXML TextField AumentoSalarioGeren;
    
    @FXML TextField NomeSecre;
    @FXML TextField SalarioSecre;
    @FXML TextField DataSecre;
    @FXML ComboBox TurnoSecre;
    @FXML ComboBox BoxSecre1;
    @FXML ComboBox BoxSecre2;
    @FXML TableView<Secretario> secretarios;
    @FXML TableColumn<Secretario,String> tableNomeSecre;
    @FXML TableColumn<Secretario,Double> tableSalarioSecre;
    @FXML TableColumn<Secretario,String> tableDataSecre;
    @FXML TableColumn<Secretario,String> tableTurnoSecre;
    @FXML TextField AumentoSalarioSecre;
    
    @FXML TextField NomeProg;
    @FXML TextField SalarioProg;
    @FXML TextField DataProg;
    @FXML TextField AreaProg;
    @FXML ComboBox BoxProg1;
    @FXML ComboBox BoxProg2;
    @FXML TableView<Programador> programadores;
    @FXML TableColumn<Programador,String> tableNomeProg;
    @FXML TableColumn<Programador,Double> tableSalarioProg;
    @FXML TableColumn<Programador,String> tableDataProg;
    @FXML TableColumn<Programador,String> tableAreaProg;
    @FXML TextField AumentoSalarioProg;
    
    @FXML TextField NomeExec;
    @FXML TextField SalarioExec;
    @FXML TextField DataExec;
    @FXML TextField BonusExec;
    @FXML ComboBox BoxExec1;
    @FXML ComboBox BoxExec2;
    @FXML TableView<Executivo> executivos;
    @FXML TableColumn<Executivo,String> tableNomeExec;
    @FXML TableColumn<Executivo,Double> tableSalarioExec;
    @FXML TableColumn<Executivo,String> tableDataExec;
    @FXML TextField AumentoSalarioExec;
    
    String driver = "org.postgresql.Driver";
    String user = "postgres";
    String senha = "123123";
    String url = "jdbc:postgresql://localhost:5432/postgres";
    Connection con=null;
    Statement st;
    
    @FXML private void ObterTurnos() throws IOException{
        TurnoSecre.setItems(FXCollections.observableArrayList("Manhã", "Tarde", "Noite"));
    }
    
    @FXML private void AddEmpre() throws IOException{
        Empregado e = new Empregado(NomeEmpre.getText(),Double.parseDouble(SalarioEmpre.getText()),DataEmpre.getText());
        EmpregadoList.add(e);
        String sentencaSQL = "insert into empregados (nome,salario,datacontratacao) values ('"+e.getNome()+"',"+e.getSalario()+",'"+e.getDataContratacao()+"')" ;
        try{
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, user, senha);
        }
        catch (ClassNotFoundException ex){
            System.err.print(ex.getMessage());
        }
        catch (SQLException ex){
            System.err.print(ex.getMessage());
        }
        try{
            st = con.createStatement();
            st.executeUpdate(sentencaSQL);
        }catch (SQLException eSQL) {
            eSQL.printStackTrace();
        }
        tableNomeEmpre.setCellValueFactory(new PropertyValueFactory<Empregado, String>("nome"));
        tableSalarioEmpre.setCellValueFactory(new PropertyValueFactory<Empregado, Double>("salario"));
        tableDataEmpre.setCellValueFactory(new PropertyValueFactory<Empregado, String>("dataContratacao"));
        empregados.getItems().add(e);
        BoxEmpre1.getItems().add(NomeEmpre.getText());
        BoxEmpre2.getItems().add(NomeEmpre.getText());
        NomeEmpre.setText("");
        SalarioEmpre.setText("");
        DataEmpre.setText("");
    }
    @FXML private void RemovEmpre() throws IOException{
        if(ConfirmarExclusão()){
            for(int i = 0;i<BoxEmpre1.getItems().size();i++){
                if(BoxEmpre1.getValue().equals(empregados.getItems().get(i).getNome())){
                    String sentencaSQL = "delete from empregados where nome='"+BoxEmpre1.getValue()+"'" ;
                    try{
                        Class.forName(driver);
                        con = (Connection) DriverManager.getConnection(url, user, senha);
                    }
                    catch (ClassNotFoundException ex){
            
                        System.err.print(ex.getMessage());
                    }
                    catch (SQLException ex){
                        System.err.print(ex.getMessage());
                    }
                    try{
                        st = con.createStatement();
                        st.executeUpdate(sentencaSQL);
                    }catch (SQLException eSQL) {
                        eSQL.printStackTrace();
                    }
                    EmpregadoList.remove(i);
                    empregados.getItems().remove(i);
                    BoxEmpre1.getItems().remove(i);
                    BoxEmpre2.getItems().remove(i);
                    break;
                }
            }
        }
        
    }
    @FXML private void AumetSalarEmpre() throws IOException{
        for(int i = 0;i<BoxEmpre2.getItems().size();i++){
            if(BoxEmpre2.getValue().equals(empregados.getItems().get(i).getNome())){
                String sentencaSQL = "update empregados set salario=salario+(salario*"+Double.parseDouble(AumentoSalarioEmpre.getText())+")/100 where nome='"+BoxEmpre2.getValue()+"'";
                try{
                    Class.forName(driver);
                    con = (Connection) DriverManager.getConnection(url, user, senha);
                }
                catch (ClassNotFoundException ex){                  
                    System.err.print(ex.getMessage());
                }
                catch (SQLException ex){
                    System.err.print(ex.getMessage());
                }
                try{
                    st = con.createStatement();
                    st.executeUpdate(sentencaSQL);
                }catch (SQLException eSQL) {
                    eSQL.printStackTrace();
                }
                Empregado e = new Empregado(empregados.getItems().get(i).getNome(),empregados.getItems().get(i).getSalario(),empregados.getItems().get(i).getDataContratacao());
                e.aumentoSalarial(Double.parseDouble(AumentoSalarioEmpre.getText()));
                empregados.getItems().set(i, e);
                AumentoSalarioEmpre.setText("");
            }
        }
    }
    
    @FXML private void AddGeren() throws IOException{
        Gerente g = new Gerente(NomeGeren.getText(),Double.parseDouble(SalarioGeren.getText()),DataGeren.getText());
        g.setBonus(Double.parseDouble(BonusGeren.getText()));
        GerenteList.add(g);
        String sentencaSQL = "insert into gerentes (nome,salarioebonus,datacontratacao) values ('"+g.getNome()+"',"+g.getSalario()+",'"+g.getDataContratacao()+"')" ;
        try{
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, user, senha);
        }
        catch (ClassNotFoundException ex){
            System.err.print(ex.getMessage());
        }
        catch (SQLException ex){
            System.err.print(ex.getMessage());
        }
        try{
            st = con.createStatement();
            st.executeUpdate(sentencaSQL);
        }catch (SQLException eSQL) {
            eSQL.printStackTrace();
        }
        tableNomeGeren.setCellValueFactory(new PropertyValueFactory<Gerente, String>("nome"));
        tableSalarioGeren.setCellValueFactory(new PropertyValueFactory<Gerente, Double>("salario"));
        tableDataGeren.setCellValueFactory(new PropertyValueFactory<Gerente, String>("dataContratacao"));
        gerentes.getItems().add(g);
        BoxGeren1.getItems().add(NomeGeren.getText());
        BoxGeren2.getItems().add(NomeGeren.getText());
        NomeGeren.setText("");
        SalarioGeren.setText("");
        DataGeren.setText("");
        BonusGeren.setText("");
    }
    @FXML private void RemovGeren() throws IOException{
        if(ConfirmarExclusão()){
            for(int i = 0;i<BoxGeren1.getItems().size();i++){
                if(BoxGeren1.getValue().equals(gerentes.getItems().get(i).getNome())){
                    String sentencaSQL = "delete from gerentes where nome='"+BoxGeren1.getValue()+"'" ;
                    try{
                        Class.forName(driver);
                        con = (Connection) DriverManager.getConnection(url, user, senha);
                    }
                    catch (ClassNotFoundException ex){
            
                        System.err.print(ex.getMessage());
                    }
                    catch (SQLException ex){
                        System.err.print(ex.getMessage());
                    }
                    try{
                        st = con.createStatement();
                        st.executeUpdate(sentencaSQL);
                    }catch (SQLException eSQL) {
                        eSQL.printStackTrace();
                    }
                    GerenteList.remove(i);
                    gerentes.getItems().remove(i);
                    BoxGeren1.getItems().remove(i);
                    BoxGeren2.getItems().remove(i);
                    break;
                }
            }
        }
        
    }
    @FXML private void AumetSalarGeren() throws IOException{
        for(int i = 0;i<BoxGeren2.getItems().size();i++){
            if(BoxGeren2.getValue().equals(gerentes.getItems().get(i).getNome())){
                String sentencaSQL = "update gerentes set salarioebonus=salarioebonus+(salarioebonus*"+Double.parseDouble(AumentoSalarioGeren.getText())+")/100 where nome='"+BoxGeren2.getValue()+"'";
                try{
                    Class.forName(driver);
                    con = (Connection) DriverManager.getConnection(url, user, senha);
                }
                catch (ClassNotFoundException ex){                  
                    System.err.print(ex.getMessage());
                }
                catch (SQLException ex){
                    System.err.print(ex.getMessage());
                }
                try{
                    st = con.createStatement();
                    st.executeUpdate(sentencaSQL);
                }catch (SQLException eSQL) {
                    eSQL.printStackTrace();
                }
                Gerente g = new Gerente(gerentes.getItems().get(i).getNome(),gerentes.getItems().get(i).getSalario(),gerentes.getItems().get(i).getDataContratacao());
                g.aumentoSalarial(Double.parseDouble(AumentoSalarioGeren.getText()));
                gerentes.getItems().set(i, g);
                AumentoSalarioGeren.setText("");
            }
        }
    }
    
    @FXML private void AddSecre() throws IOException{
        Secretario s = new Secretario(NomeSecre.getText(),Double.parseDouble(SalarioSecre.getText()),DataSecre.getText(),TurnoSecre.getValue().toString());
        SecretarioList.add(s);
        String sentencaSQL = "insert into secretarios (nome,salario,datacontratacao,turno) values ('"+s.getNome()+"',"+s.getSalario()+",'"+s.getDataContratacao()+"','"+s.getTurno()+"')" ;
        try{
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, user, senha);
        }
        catch (ClassNotFoundException ex){
            System.err.print(ex.getMessage());
        }
        catch (SQLException ex){
            System.err.print(ex.getMessage());
        }
        try{
            st = con.createStatement();
            st.executeUpdate(sentencaSQL);
        }catch (SQLException eSQL) {
            eSQL.printStackTrace();
        }
        tableNomeSecre.setCellValueFactory(new PropertyValueFactory<Secretario, String>("nome"));
        tableSalarioSecre.setCellValueFactory(new PropertyValueFactory<Secretario, Double>("salario"));
        tableDataSecre.setCellValueFactory(new PropertyValueFactory<Secretario, String>("dataContratacao"));
        tableTurnoSecre.setCellValueFactory(new PropertyValueFactory<Secretario, String>("turno"));
        secretarios.getItems().add(s);
        BoxSecre1.getItems().add(NomeSecre.getText());
        BoxSecre2.getItems().add(NomeSecre.getText());
        NomeSecre.setText("");
        SalarioSecre.setText("");
        DataSecre.setText("");
    }
    @FXML private void RemovSecre() throws IOException{
        if(ConfirmarExclusão()){
            for(int i = 0;i<BoxSecre1.getItems().size();i++){
                if(BoxSecre1.getValue().equals(secretarios.getItems().get(i).getNome())){
                    String sentencaSQL = "delete from secretarios where nome='"+BoxSecre1.getValue()+"'" ;
                    try{
                        Class.forName(driver);
                        con = (Connection) DriverManager.getConnection(url, user, senha);
                    }
                    catch (ClassNotFoundException ex){
            
                        System.err.print(ex.getMessage());
                    }
                    catch (SQLException ex){
                        System.err.print(ex.getMessage());
                    }
                    try{
                        st = con.createStatement();
                        st.executeUpdate(sentencaSQL);
                    }catch (SQLException eSQL) {
                        eSQL.printStackTrace();
                    }
                    SecretarioList.remove(i);
                    secretarios.getItems().remove(i);
                    BoxSecre1.getItems().remove(i);
                    BoxSecre2.getItems().remove(i);
                    break;
                }
            }
        }
        
    }
    @FXML private void AumetSalarSecre() throws IOException{
        for(int i = 0;i<BoxSecre2.getItems().size();i++){
            if(BoxSecre2.getValue().equals(secretarios.getItems().get(i).getNome())){
                String sentencaSQL = "update secretarios set salario=salario+(salario*"+Double.parseDouble(AumentoSalarioSecre.getText())+")/100 where nome='"+BoxSecre2.getValue()+"'";
                try{
                    Class.forName(driver);
                    con = (Connection) DriverManager.getConnection(url, user, senha);
                }
                catch (ClassNotFoundException ex){                  
                    System.err.print(ex.getMessage());
                }
                catch (SQLException ex){
                    System.err.print(ex.getMessage());
                }
                try{
                    st = con.createStatement();
                    st.executeUpdate(sentencaSQL);
                }catch (SQLException eSQL) {
                    eSQL.printStackTrace();
                }
                Secretario s = new Secretario(secretarios.getItems().get(i).getNome(),secretarios.getItems().get(i).getSalario(),secretarios.getItems().get(i).getDataContratacao(),secretarios.getItems().get(i).getTurno());
                s.aumentoSalarial(Double.parseDouble(AumentoSalarioSecre.getText()));
                secretarios.getItems().set(i, s);
                AumentoSalarioSecre.setText("");
            }
        }
    }
    
    @FXML private void AddProg() throws IOException{
        Programador p = new Programador(NomeProg.getText(),Double.parseDouble(SalarioProg.getText()),DataProg.getText(),AreaProg.getText());
        ProgramadorList.add(p);
        String sentencaSQL = "insert into programadores (nome,salario,datacontratacao,area) values ('"+p.getNome()+"',"+p.getSalario()+",'"+p.getDataContratacao()+"','"+p.getAreaProg()+"')" ;
        try{
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, user, senha);
        }
        catch (ClassNotFoundException ex){
            System.err.print(ex.getMessage());
        }
        catch (SQLException ex){
            System.err.print(ex.getMessage());
        }
        try{
            st = con.createStatement();
            st.executeUpdate(sentencaSQL);
        }catch (SQLException eSQL) {
            eSQL.printStackTrace();
        }
        tableNomeProg.setCellValueFactory(new PropertyValueFactory<Programador, String>("nome"));
        tableSalarioProg.setCellValueFactory(new PropertyValueFactory<Programador, Double>("salario"));
        tableDataProg.setCellValueFactory(new PropertyValueFactory<Programador, String>("dataContratacao"));
        tableAreaProg.setCellValueFactory(new PropertyValueFactory<Programador, String>("areaProg"));
        programadores.getItems().add(p);
        BoxProg1.getItems().add(NomeProg.getText());
        BoxProg2.getItems().add(NomeProg.getText());
        NomeProg.setText("");
        SalarioProg.setText("");
        DataProg.setText("");
        AreaProg.setText("");
    }
    @FXML private void RemovProg() throws IOException{
        if(ConfirmarExclusão()){
            for(int i = 0;i<BoxProg1.getItems().size();i++){
                if(BoxProg1.getValue().equals(programadores.getItems().get(i).getNome())){
                    String sentencaSQL = "delete from programadores where nome='"+BoxProg1.getValue()+"'" ;
                    try{
                        Class.forName(driver);
                        con = (Connection) DriverManager.getConnection(url, user, senha);
                    }
                    catch (ClassNotFoundException ex){
            
                        System.err.print(ex.getMessage());
                    }
                    catch (SQLException ex){
                        System.err.print(ex.getMessage());
                    }
                    try{
                        st = con.createStatement();
                        st.executeUpdate(sentencaSQL);
                    }catch (SQLException eSQL) {
                        eSQL.printStackTrace();
                    }
                    ProgramadorList.remove(i);
                    programadores.getItems().remove(i);
                    BoxProg1.getItems().remove(i);
                    BoxProg2.getItems().remove(i);
                    break;
                }
            }
        }
    }
    @FXML private void AumetSalarProg() throws IOException{
        for(int i = 0;i<BoxProg2.getItems().size();i++){
            if(BoxProg2.getValue().equals(programadores.getItems().get(i).getNome())){
                String sentencaSQL = "update programadores set salario=salario+(salario*"+Double.parseDouble(AumentoSalarioProg.getText())+")/100 where nome='"+BoxProg2.getValue()+"'";
                try{
                    Class.forName(driver);
                    con = (Connection) DriverManager.getConnection(url, user, senha);
                }
                catch (ClassNotFoundException ex){                  
                    System.err.print(ex.getMessage());
                }
                catch (SQLException ex){
                    System.err.print(ex.getMessage());
                }
                try{
                    st = con.createStatement();
                    st.executeUpdate(sentencaSQL);
                }catch (SQLException eSQL) {
                    eSQL.printStackTrace();
                }
                Programador p = new Programador(programadores.getItems().get(i).getNome(),programadores.getItems().get(i).getSalario(),programadores.getItems().get(i).getDataContratacao(),programadores.getItems().get(i).getAreaProg());
                p.aumentoSalarial(Double.parseDouble(AumentoSalarioProg.getText()));
                programadores.getItems().set(i, p);
                AumentoSalarioProg.setText("");
            }
        }
    }
    
    @FXML private void AddExec() throws IOException{
        Executivo ex = new Executivo(NomeExec.getText(),Double.parseDouble(SalarioExec.getText()),DataExec.getText());
        ex.setBonusCooparticipacao(Double.parseDouble(BonusExec.getText()));
        ExecutivoList.add(ex);
        String sentencaSQL = "insert into executivos (nome,salarioebonus,datacontratacao) values ('"+ex.getNome()+"',"+ex.getSalario()+",'"+ex.getDataContratacao()+"')" ;
        try{
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, user, senha);
        }
        catch (ClassNotFoundException e){
            System.err.print(e.getMessage());
        }
        catch (SQLException e){
            System.err.print(e.getMessage());
        }
        try{
            st = con.createStatement();
            st.executeUpdate(sentencaSQL);
        }catch (SQLException eSQL) {
            eSQL.printStackTrace();
        }
        tableNomeExec.setCellValueFactory(new PropertyValueFactory<Executivo, String>("nome"));
        tableSalarioExec.setCellValueFactory(new PropertyValueFactory<Executivo, Double>("salario"));
        tableDataExec.setCellValueFactory(new PropertyValueFactory<Executivo, String>("dataContratacao"));
        executivos.getItems().add(ex);
        BoxExec1.getItems().add(NomeExec.getText());
        BoxExec2.getItems().add(NomeExec.getText());
        NomeExec.setText("");
        SalarioExec.setText("");
        DataExec.setText("");
        BonusExec.setText("");
    }
    @FXML private void RemovExec() throws IOException{
        if(ConfirmarExclusão()){
            for(int i = 0;i<BoxExec1.getItems().size();i++){
                if(BoxExec1.getValue().equals(executivos.getItems().get(i).getNome())){
                    String sentencaSQL = "delete from executivos where nome='"+BoxExec1.getValue()+"'" ;
                    try{
                        Class.forName(driver);
                        con = (Connection) DriverManager.getConnection(url, user, senha);
                    }
                    catch (ClassNotFoundException ex){
            
                        System.err.print(ex.getMessage());
                    }
                    catch (SQLException ex){
                        System.err.print(ex.getMessage());
                    }
                    try{
                        st = con.createStatement();
                        st.executeUpdate(sentencaSQL);
                    }catch (SQLException eSQL) {
                        eSQL.printStackTrace();
                    }
                    ExecutivoList.remove(i);
                    executivos.getItems().remove(i);
                    BoxExec1.getItems().remove(i);
                    BoxExec2.getItems().remove(i);
                    break;
                }
            }
        }
    }
    @FXML private void AumetSalarExec() throws IOException{
        for(int i = 0;i<BoxExec2.getItems().size();i++){
            if(BoxExec2.getValue().equals(executivos.getItems().get(i).getNome())){
                String sentencaSQL = "update executivos set salarioebonus=salarioebonus+(salarioebonus*"+Double.parseDouble(AumentoSalarioExec.getText())+")/100 where nome='"+BoxExec2.getValue()+"'";
                try{
                    Class.forName(driver);
                    con = (Connection) DriverManager.getConnection(url, user, senha);
                }
                catch (ClassNotFoundException ex){                  
                    System.err.print(ex.getMessage());
                }
                catch (SQLException ex){
                    System.err.print(ex.getMessage());
                }
                try{
                    st = con.createStatement();
                    st.executeUpdate(sentencaSQL);
                }catch (SQLException eSQL) {
                    eSQL.printStackTrace();
                }
                Executivo ex = new Executivo(executivos.getItems().get(i).getNome(),executivos.getItems().get(i).getSalario(),executivos.getItems().get(i).getDataContratacao());
                ex.aumentoSalarial(Double.parseDouble(AumentoSalarioExec.getText()));
                executivos.getItems().set(i, ex);
                AumentoSalarioExec.setText("");
            }
        }
    }
    
    @FXML private void TrocarTela () throws IOException{
        App.setRoot("primary");
    }
    
    @FXML private void RecuperarEmpre () throws IOException{
        try{
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, user, senha);
        }
        catch (ClassNotFoundException e){
            System.err.print(e.getMessage());
        }
        catch (SQLException e){
            System.err.print(e.getMessage());
        }
        try{
            ConfirmarApagarDados();
            LimparTabelas(0);
            st = con.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM empregados;");
            while (resultSet.next()){
                Empregado e = new Empregado(resultSet.getObject(1).toString(),Double.parseDouble(resultSet.getObject(2).toString()),resultSet.getObject(3).toString());
                EmpregadoList.add(e);
                tableNomeEmpre.setCellValueFactory(new PropertyValueFactory<Empregado, String>("nome"));
                tableSalarioEmpre.setCellValueFactory(new PropertyValueFactory<Empregado, Double>("salario"));
                tableDataEmpre.setCellValueFactory(new PropertyValueFactory<Empregado, String>("dataContratacao"));
                empregados.getItems().add(e);
                BoxEmpre1.getItems().add(e.getNome());
                BoxEmpre2.getItems().add(e.getNome());
            }
        }catch (SQLException eSQL) {
            eSQL.printStackTrace();
        }
    }
    @FXML private void RecuperarGeren () throws IOException{
        try{
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, user, senha);
        }
        catch (ClassNotFoundException e){
            System.err.print(e.getMessage());
        }
        catch (SQLException e){
            System.err.print(e.getMessage());
        }
        try{
            ConfirmarApagarDados();
            LimparTabelas(1);
            st = con.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM gerentes;");
            while (resultSet.next()){
                Gerente g = new Gerente(resultSet.getObject(1).toString(),Double.parseDouble(resultSet.getObject(2).toString()),resultSet.getObject(3).toString());
                GerenteList.add(g);
                tableNomeGeren.setCellValueFactory(new PropertyValueFactory<Gerente, String>("nome"));
                tableSalarioGeren.setCellValueFactory(new PropertyValueFactory<Gerente, Double>("salario"));
                tableDataGeren.setCellValueFactory(new PropertyValueFactory<Gerente, String>("dataContratacao"));
                gerentes.getItems().add(g);
                BoxGeren1.getItems().add(g.getNome());
                BoxGeren2.getItems().add(g.getNome());
            }
        }catch (SQLException eSQL) {
            eSQL.printStackTrace();
        }
    }
    @FXML private void RecuperarSecre () throws IOException{
        try{
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, user, senha);
        }
        catch (ClassNotFoundException e){
            System.err.print(e.getMessage());
        }
        catch (SQLException e){
            System.err.print(e.getMessage());
        }
        try{
            ConfirmarApagarDados();
            LimparTabelas(2);
            st = con.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM secretarios;");
            while (resultSet.next()){
                Secretario s = new Secretario(resultSet.getObject(1).toString(),Double.parseDouble(resultSet.getObject(2).toString()),resultSet.getObject(3).toString(),resultSet.getObject(4).toString());
                SecretarioList.add(s);
                tableNomeSecre.setCellValueFactory(new PropertyValueFactory<Secretario, String>("nome"));
                tableSalarioSecre.setCellValueFactory(new PropertyValueFactory<Secretario, Double>("salario"));
                tableDataSecre.setCellValueFactory(new PropertyValueFactory<Secretario, String>("dataContratacao"));
                tableTurnoSecre.setCellValueFactory(new PropertyValueFactory<Secretario, String>("turno"));
                secretarios.getItems().add(s);
                BoxSecre1.getItems().add(s.getNome());
                BoxSecre2.getItems().add(s.getNome());
            }
        }catch (SQLException eSQL) {
            eSQL.printStackTrace();
        }
    }
    @FXML private void RecuperarProg () throws IOException{
        try{
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, user, senha);
        }
        catch (ClassNotFoundException e){
            System.err.print(e.getMessage());
        }
        catch (SQLException e){
            System.err.print(e.getMessage());
        }
        try{
            ConfirmarApagarDados();
            LimparTabelas(3);
            st = con.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM programadores;");
            while (resultSet.next()){
                Programador p = new Programador(resultSet.getObject(1).toString(),Double.parseDouble(resultSet.getObject(2).toString()),resultSet.getObject(3).toString(),resultSet.getObject(4).toString());
                ProgramadorList.add(p);
                tableNomeProg.setCellValueFactory(new PropertyValueFactory<Programador, String>("nome"));
                tableSalarioProg.setCellValueFactory(new PropertyValueFactory<Programador, Double>("salario"));
                tableDataProg.setCellValueFactory(new PropertyValueFactory<Programador, String>("dataContratacao"));
                tableAreaProg.setCellValueFactory(new PropertyValueFactory<Programador, String>("areaProg"));
                programadores.getItems().add(p);
                BoxProg1.getItems().add(p.getNome());
                BoxProg2.getItems().add(p.getNome());
            }
        }catch (SQLException eSQL) {
            eSQL.printStackTrace();
        }
    }
    @FXML private void RecuperarExec () throws IOException{
        try{
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, user, senha);
        }
        catch (ClassNotFoundException e){
            System.err.print(e.getMessage());
        }
        catch (SQLException e){
            System.err.print(e.getMessage());
        }
        try{
            ConfirmarApagarDados();
            LimparTabelas(4);
            st = con.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM executivos;");
            while (resultSet.next()){
                Executivo ex = new Executivo(resultSet.getObject(1).toString(),Double.parseDouble(resultSet.getObject(2).toString()),resultSet.getObject(3).toString());
                ExecutivoList.add(ex);
                tableNomeExec.setCellValueFactory(new PropertyValueFactory<Executivo, String>("nome"));
                tableSalarioExec.setCellValueFactory(new PropertyValueFactory<Executivo, Double>("salario"));
                tableDataExec.setCellValueFactory(new PropertyValueFactory<Executivo, String>("dataContratacao"));
                executivos.getItems().add(ex);
                BoxExec1.getItems().add(ex.getNome());
                BoxExec2.getItems().add(ex.getNome());
            }
        }catch (SQLException eSQL) {
            eSQL.printStackTrace();
        }
    }
    
    private void ConfirmarApagarDados() throws IOException{
        Alert msg_conf = new Alert(Alert.AlertType.INFORMATION);
        msg_conf.setTitle("Informação");
        msg_conf.setHeaderText("Você clicou em Recuperar dados do SGBD.");
        msg_conf.setContentText("Aviso: O arquivo salvo foi lido, logo todos os dados entraram na tabela.");
        msg_conf.showAndWait();
    }
    private boolean ConfirmarExclusão() throws IOException{
        Alert msg_conf = new Alert(Alert.AlertType.CONFIRMATION);
        msg_conf.setTitle("Confirmação");
        msg_conf.setHeaderText("Você clicou para excluir um funcionario.");
        msg_conf.setContentText("Tem certeza?");
        Optional<ButtonType> result = msg_conf.showAndWait();
        return result.get() == ButtonType.OK;
    }
    private void LimparTabelas(int op) throws IOException{
        switch(op){
            case 0:
                for(int i = 0;!EmpregadoList.isEmpty();i++){
                    EmpregadoList.remove(0);
                    empregados.getItems().remove(0);
                    BoxEmpre1.getItems().remove(0);
                    BoxEmpre2.getItems().remove(0);
                }
                break;
            case 1:
                for(int i = 0;!GerenteList.isEmpty();i++){
                    GerenteList.remove(0);
                    gerentes.getItems().remove(0);
                    BoxGeren1.getItems().remove(0);
                    BoxGeren2.getItems().remove(0);
                }
                break;
            case 2:
                for(int i = 0;!SecretarioList.isEmpty();i++){
                    SecretarioList.remove(0);
                    secretarios.getItems().remove(0);
                    BoxSecre1.getItems().remove(0);
                    BoxSecre2.getItems().remove(0);
                }
                break;
            case 3:
                for(int i = 0;!ProgramadorList.isEmpty();i++){
                    ProgramadorList.remove(0);
                    programadores.getItems().remove(0);
                    BoxProg1.getItems().remove(0);
                    BoxProg2.getItems().remove(0);
                }
                break;
            case 4:
                for(int i = 0;!ExecutivoList.isEmpty();i++){
                    ExecutivoList.remove(0);
                    executivos.getItems().remove(0);
                    BoxExec1.getItems().remove(0);
                    BoxExec2.getItems().remove(0);
                }
                break;
        }
    }
}
