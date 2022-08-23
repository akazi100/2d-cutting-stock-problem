package gui;


import java.util.Random;
import java.io.File;
import java.io.IOException;

import ga.GeneticAlgorithm;
import ga.geneticOperators.OrderedCrossover;
import ga.geneticOperators.PieceMutation;
import ga.selectionMethods.Tournament;
import project.Project;
import project.ProjectIndividual;

public class Runner {
    public static void main(String[] args) {
        int popSize = 100;
        GeneticAlgorithm<ProjectIndividual, Project> ga = new GeneticAlgorithm<ProjectIndividual, Project>(
                    popSize,
                    100,
                    new Tournament<ProjectIndividual, Project>(
                        popSize,
                        2),
                    new OrderedCrossover<ProjectIndividual>(0.7),
                    new PieceMutation<ProjectIndividual>(0.001),
                    new Random(1));
        System.out.println("got here");
        File dataSet = new File("./datasets/problem1.txt");

        try {
            Project project = Project.buildProject(dataSet);
            int[][] pieces = ga.run(project).getPieces();
            // for (int i = 0; i < pieces.length; i++) {
            //     for (int j = 0; j < pieces[i].length; j++) {
            //         System.out.print(pieces[i][j]);
            //     }
            //     System.out.println();
            // }

            // String text = "";
            // int[][] rawMaterialMatrix = new int[project.getRawMaterialLines()][project.getRawMaterialColumns()];
            // for (int rawLine = 0; rawLine < project.getRawMaterialLines(); rawLine++) {
            //     String tempLine = "";
            //     int numEmptyCells = 0;
                
            //     for (int rawColumn = 0; rawColumn < project.getRawMaterialColumns(); rawColumn++) {
            //         if (rawMaterialMatrix[rawLine][rawColumn] == 0) {
            //             numEmptyCells++;
            //             tempLine += "<font color=#FFFFFF>\u25a1</font>";
            //         } else {
            //             tempLine += "<font color=" + project.getColor(rawMaterialMatrix[rawLine][rawColumn] - 1) + ">\u25a0</font>";
            //         }
            //     }
    
            //     if (numEmptyCells == project.getRawMaterialColumns()) {
            //         break;
            //     } else {
            //         text += "|" + tempLine + "|<br>";
            //     }
            // }
            // System.out.println(text);
            // ProjectIndividual problem = new ProjectIndividual(project);
            // String text = problem.toStringWithColors();


            System.out.println(ga.run(project).toString());

            
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
