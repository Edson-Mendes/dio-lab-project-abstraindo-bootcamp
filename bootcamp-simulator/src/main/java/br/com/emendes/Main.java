package br.com.emendes;

import br.com.emendes.domain.Bootcamp;
import br.com.emendes.domain.Course;
import br.com.emendes.domain.Dev;
import br.com.emendes.domain.Mentoring;

import java.time.LocalDate;

public class Main {

  public static void main(String[] args) {
    Course javaCourse = Course.builder()
        .workload(6)
        .title("Java introduction")
        .description("Introductory Java course")
        .build();

    Course hibernateCourse = Course.builder()
        .workload(2)
        .title("Hibernate course")
        .description("Hibernate course")
        .build();

    System.out.println(javaCourse);

    Mentoring springMentoring = Mentoring.builder()
        .description("Developing a REST API with Springboot")
        .title("Springboot mentoring")
        .date(LocalDate.now())
        .build();

    System.out.println(springMentoring);
    System.out.println("---------------------------------------------");

    Dev johnDev = new Dev("John Doe");
    johnDev.addContent(javaCourse);
    johnDev.addContent(springMentoring);
    johnDev.toProgress();
    System.out.println(johnDev);

    Dev janeDev = new Dev("Jane Doe");
    janeDev.addContent(javaCourse);
    janeDev.addContent(springMentoring);
    janeDev.toProgress();
    System.out.println(janeDev);

    Bootcamp bootcamp = new Bootcamp(
        "Bootcamp DIO Springboot",
        "Bootcamp com foco em Springboot e Java", LocalDate.now(), LocalDate.now().plusDays(60));

    bootcamp.addContent(javaCourse);
    bootcamp.addContent(springMentoring);
    bootcamp.addContent(hibernateCourse);

    bootcamp.subscribeDev(janeDev);
    bootcamp.subscribeDev(johnDev);

    System.out.println("------------------------------------------------------");
    System.out.println(bootcamp);
  }

}