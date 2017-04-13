package fr.flegac.experiments.delaunay;

import java.util.Random;

import fr.flegac.experiments.delaunay.v2.Delaunay;
import fr.flegac.experiments.delaunay.v2.edge.Edge;
import fr.flegac.experiments.delaunay.v2.point.ArrayPointCloud;
import fr.flegac.experiments.delaunay.v2.point.PointCloud.Vec;
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

        ArrayPointCloud points = new ArrayPointCloud(20);

        Delaunay delaunay = new Delaunay(points);

        Group root = new Group();

        Group edges = new Group();
        edges.setScaleX(1);
        edges.setScaleY(1);
        for (Edge edge : delaunay.edges()) {
            Vec a = points.get(edge.origin);
            Vec b = points.get(edge.inner.origin);
            Line line = new Line(a.x(), a.y(), b.x(), b.y());
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
