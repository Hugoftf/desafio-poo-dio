import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Curso cursoJava = new Curso("Curso Java", "Descrição do curso Java", 8);
        Curso cursoJs = new Curso("Curso JavaScript", "Descrição do curso JavaScript", 4);
        Mentoria mentoriaJava = new Mentoria("Mentoria de Java", "Descrição da mentoria Java", LocalDate.now());

        Bootcamp bootcampJavaDev = new Bootcamp();
        bootcampJavaDev.setNome("Bootcamp Java Developer");
        bootcampJavaDev.setDescricao("Descrição do Bootcamp Java Developer");

        bootcampJavaDev.adicionarConteudo(cursoJava);
        bootcampJavaDev.adicionarConteudo(cursoJs);
        bootcampJavaDev.adicionarConteudo(mentoriaJava);

        Dev devCamila = new Dev();
        devCamila.setNome("Camila");

        devCamila.inscreverBootcamp(bootcampJavaDev);

        System.out.println("Conteúdos Inscritos Camila: " + devCamila.getConteudosInscritos());
        
        devCamila.progredir(); 
        devCamila.progredir();  

        System.out.println("- Conteúdos Inscritos Camila: " + devCamila.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos Camila: " + devCamila.getConteudosConcluidos());
        System.out.println("XP Camila: " + devCamila.calcularTotalXp());

        System.out.println("-------");

        Dev devJoao = new Dev();
        devJoao.setNome("João");

        devJoao.inscreverBootcamp(bootcampJavaDev);

        System.out.println("Conteúdos Inscritos João: " + devJoao.getConteudosInscritos());
        
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();

        System.out.println("- Conteúdos Inscritos João: " + devJoao.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos João: " + devJoao.getConteudosConcluidos());
        System.out.println("XP João: " + devJoao.calcularTotalXp());
    }
}

