package br.com.dio.desafio.dominio;

import java.util.*;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp) {
        if (bootcamp.getConteudos().isEmpty()) {
            System.err.println("O Bootcamp não possui conteúdos para inscrição!");
            return;
        }

        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.adicionarDev(this); 

        System.out.println(this.nome + " está inscrito nos seguintes conteúdos:");
        this.conteudosInscritos.forEach(conteudo -> System.out.println(conteudo.getTitulo()));
    }

   
    public void progredir() {
        // Verifica se o dev tem conteúdos inscritos
        if (!this.conteudosInscritos.isEmpty()) {
            // Pega o primeiro conteúdo da lista de inscritos (mas podemos melhorar isso se quiser usar mais lógica)
            Iterator<Conteudo> iterator = this.conteudosInscritos.iterator();
            if (iterator.hasNext()) {
                Conteudo conteudo = iterator.next(); // Pega o primeiro conteúdo
                this.conteudosConcluidos.add(conteudo); // Marca como concluído
                this.conteudosInscritos.remove(conteudo); // Remove da lista de inscritos
            }
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    public double calcularTotalXp() {
        return this.conteudosConcluidos
            .stream()
            .mapToDouble(Conteudo::calcularXp)
            .sum();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) &&
                Objects.equals(conteudosInscritos, dev.conteudosInscritos) &&
                Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}
