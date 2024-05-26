package br.com.alura.TabelaFipe.main;

import br.com.alura.TabelaFipe.model.Dados;
import br.com.alura.TabelaFipe.model.Modelos;
import br.com.alura.TabelaFipe.model.Veiculo;
import br.com.alura.TabelaFipe.services.ConsumoAPI;
import br.com.alura.TabelaFipe.services.ConverteDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public String azul="\u001B[34m";
    public String finaliza="\u001B[0m";
    private Scanner sc = new Scanner(System.in);
    private final String URL_BASE="https://parallelum.com.br/fipe/api/v1/";
    private ConsumoAPI consumo= new ConsumoAPI();
    private ConverteDados conversor= new ConverteDados();
    public void exibeMenu(){
        var menu =azul+ """
                *** OPÇÕES ***"""+finaliza+
                """
                
                Carro
                Moto
                Caminhão"""
                +azul+ """
                
                Digite uma das opções para consultar:
                """+finaliza;
        System.out.println(menu);
        var opcao=sc.nextLine();
        String endereco;

        if (opcao.toLowerCase().contains("car")){
            endereco= URL_BASE+"carros/marcas";
        }else if(opcao.toLowerCase().contains("mot")) {
            endereco = URL_BASE + "motos/marcas";
        }else{
            endereco = URL_BASE + "caminhoes/marcas";
        }

        var json= consumo.obterDados(endereco);
        var marcas= conversor.obterListaDados(json, Dados.class);

        System.out.println(azul+"Marcas disponíveis para consulta: (LISTA LONGA)"+finaliza);

        marcas.stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);


        System.out.println(azul+"Informe o codigo da marca para consulta: "+finaliza);
        var codMarca= sc.nextLine();

        endereco=endereco+"/" + codMarca + "/modelos";
        json=consumo.obterDados(endereco);


        var modelosLista= conversor.obterDados(json, Modelos.class);
        System.out.println(azul+"Modelos dessa marca: (LISTA LONGA)"+finaliza);
        modelosLista.modelos().stream()
                        .sorted(Comparator.comparing(Dados::codigo))
                        .forEach(System.out::println);

        System.out.println(azul+"\nDigite um trecho do nome do veículo para consultar: "+finaliza);
        var nomeVeiculo =sc.nextLine();

        List<Dados> modelosFiltrados = modelosLista.modelos().stream()
                        .filter(m -> m.nome().toLowerCase().contains(nomeVeiculo.toLowerCase()))
                        .collect(Collectors.toList());

        System.out.println(azul+"Modelos filtrados: "+finaliza);
        modelosFiltrados.forEach(System.out::println);


        System.out.println(azul+"Digite o código do modelo para consultar o ano: "+finaliza);
        var codModelo= sc.nextLine();

        endereco=endereco+"/" + codModelo + "/anos";
        json=consumo.obterDados(endereco);

        List<Dados> anos = conversor.obterListaDados(json, Dados.class);

        List<Veiculo> veiculos = new ArrayList<>();

        for (Dados ano : anos) {
            String enderecoNovo=endereco+"/" + ano.codigo();
            json=consumo.obterDados(enderecoNovo);
            var veiculo = conversor.obterDados(json, Veiculo.class);
            veiculos.add(veiculo);
        }
        System.out.println(azul+"Todos os veiculos filtrados com avaliações por ano: "+finaliza);
        veiculos.forEach(System.out::println);
        sc.close();
    }
}
