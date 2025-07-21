package com.projectrunner.app.examples;


import com.projectrunner.app.Edge;
import com.projectrunner.app.Node;
import com.projectrunner.app.ProjFlow;

import java.io.IOException;

public class ProjectRunner {
    public static void main(String[] args) throws IOException {
        ProjFlow sdk = new ProjFlow();

        Node start = new Node("Start", ctx -> {
            System.out.println("Hello from Start");
            try {
                String projectPath = "D:/coding/React/hackverse";
                new ProcessBuilder("cmd", "/c", "code \"" + projectPath + "\"").start();

                // 2. Run `npm run dev` in a new terminal inside that folder
                new ProcessBuilder("cmd", "/c", "start cmd /k \"cd /d " + projectPath + " && npm run dev\"").start();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return "Middle";
        });

        Node middle = new Node("Middle", ctx -> {
            String vs = "C:/Program Files/Microsoft Visual Studio/2022/Community/Common7/IDE/devenv.exe/";
            String projPath = "D:/coding/csharp/HackverseServer";
            try {
                new ProcessBuilder(vs,projPath).start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hello from Middle");

            return "End";
        });

        Node end = new Node("End", ctx -> {
            try {
                new ProcessBuilder("cmd","/c","start chrome \""+"http://localhost:5173"+"\"").start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hello from End");
            return null;
        });

        sdk.addNode(start);
        sdk.addNode(middle);
        sdk.addNode(end);

        sdk.addEdge(new Edge("Start", "Middle"));
        sdk.addEdge(new Edge("Middle", "End"));

        sdk.run("Start");
    }
}
