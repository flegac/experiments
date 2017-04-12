package fr.flegac.experiments.delaunay;

import java.util.Random;

import fr.flegac.experiments.delaunay.v2.Delaunay;
import fr.flegac.experiments.delaunay.v2.Edge;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

public class DelaunayViewer extends Application {
    private static Random rand = new Random(54);

    public static void main(final String[] args) {
        launch(args);
    }

    private static float scale = 1;

    @Override
    public void start(final Stage primaryStage) {
        int N = 100;
        float[] x = new float[N];
        float[] y = new float[N];

        for (int i = 0; i < N; i++) {
            x[i] = rand.nextFloat() * 100;
            y[i] = rand.nextFloat() * 100;
        }

        Delaunay delaunay = new Delaunay(x, y);

        Group root = new Group();

        Group edges = new Group();
        edges.setScaleX(1);
        edges.setScaleY(1);
        for (Edge edge : delaunay.edges()) {
            Line line = new Line(edge.start().x(), edge.start().y(), edge.end().x(), edge.end().y());
            line.setStrokeType(StrokeType.OUTSIDE);
            line.setStroke(Color.BLUE);
            line.setStrokeWidth(.1);
            edges.getChildren().add(line);
        }
        root.getChildren().add(edges);

        // scene
        final Scene scene = new Scene(new ScrollPane(root), 500, 500);
        scene.setOnScroll(event -> {
            scale *= event.getDeltaY() > 0 ? 1.1 : 1 / 1.1;
            root.setScaleX(scale);
            root.setScaleY(scale);
            System.out.println(event);
        });

        primaryStage.setScene(scene);
        primaryStage.setWidth(600);
        primaryStage.setHeight(600);
        primaryStage.setTitle("Tiling viewer");
        primaryStage.show();

    }

}
