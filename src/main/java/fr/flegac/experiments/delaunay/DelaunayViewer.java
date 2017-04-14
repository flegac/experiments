package fr.flegac.experiments.delaunay;

import fr.flegac.experiments.delaunay.edge.Edge;
import fr.flegac.experiments.delaunay.point.ArrayPointCloud;
import fr.flegac.experiments.delaunay.point.PointCloud.Vec;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DelaunayViewer extends Application {
    public static void main(final String[] args) {
        launch(args);
    }

    private static float scale = 400;

    @Override
    public void start(final Stage primaryStage) {

        ArrayPointCloud points = new ArrayPointCloud(25);
        Delaunay delaunay = new Delaunay(points);
        delaunay.triangulate();

        Group root = new Group();

        root.setTranslateX(-150);
        root.setTranslateY(-150);

        Group edges = new Group();
        edges.setScaleX(scale);
        edges.setScaleY(scale);
        for (Edge edge : delaunay.edges()) {
            Vec a = edge.origin;
            Vec b = edge.inner.origin;
            Line line = new Line(a.x(), -a.y(), b.x(), -b.y());
            line.setStrokeType(StrokeType.OUTSIDE);
            line.setStroke(Color.BLUE);
            line.setStrokeWidth(.001);
            edges.getChildren().add(line);

            // show(edge.origin, edges);
            // show(points.get(edge.origin.index), edges);

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

    private void show(Vec a, Group edges) {
        Text ta = new Text(a.x(), -a.y(), "" + a.index);
        ta.setFont(Font.font(null, FontWeight.NORMAL, .1));
        ta.setStroke(Color.BLACK);
        ta.setFill(Color.BLACK);
        ta.setStrokeWidth(.01);
        edges.getChildren().add(ta);
    }

}
