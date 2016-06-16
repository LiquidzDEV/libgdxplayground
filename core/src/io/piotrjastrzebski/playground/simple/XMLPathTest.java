package io.piotrjastrzebski.playground.simple;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.DelaunayTriangulator;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.ShortArray;
import io.piotrjastrzebski.playground.BaseScreen;
import io.piotrjastrzebski.playground.GameReset;
import io.piotrjastrzebski.playground.PlaygroundGame;
import net.dermetfan.gdx.math.BayazitDecomposer;

/**
 * Created by EvilEntity on 25/01/2016.
 */
public class XMLPathTest extends BaseScreen {
	private static final String TAG = XMLPathTest.class.getSimpleName();

	String xmlBox = "M 0,952.36218 L 100,952.36218 L 100,1052.3622 L 0,1052.3622 Z";
	String xmlInner = "M 66.31743,1052.7874 L 64.629158,1049.7911 L 64.001728,1046.7152 L 64.893835,1040.3964 L 66.922627,1033.9748 L 68.01698,1027.5941 L 67.51063,1024.2672 L 66.179886,1021.7339 L 64.194184,1019.8853 L 61.722963,1018.6122 L 56.001716,1017.3571 L 50.37165,1017.0968 L 44.542746,1017.284 L 38.578245,1018.52 L 35.994292,1019.7954 L 33.915414,1021.6499 L 32.521271,1024.1891 L 31.99152,1027.5187 L 33.085882,1033.8994 L 35.114672,1040.3211 L 36.006774,1046.6398 L 35.379343,1049.7157 L 33.69107,1052.712 L 30.728971,1054.6355 L 26.201547,1055.5058 L 14.867496,1055.0691 L 0,1052.3622 L 2.706905,1037.4947 L 3.1436775,1026.1606 L 2.2733933,1021.6332 L 0.3499,1018.6711 L -2.6463682,1016.9828 L -5.7222662,1016.3554 L -12.041063,1017.2475 L -18.46271,1019.2763 L -24.84343,1020.3706 L -28.172993,1019.8409 L -30.712149,1018.4467 L -32.566553,1016.3679 L -33.841862,1013.7839 L -35.077822,1007.8194 L -35.26528,1001.9905 L -35.005005,996.36044 L -33.749919,990.63918 L -32.47688,988.16794 L -30.628209,986.18223 L -28.094927,984.85146 L -24.76806,984.3451 L -18.387336,985.4396 L -11.965688,987.46841 L -5.6468906,988.36046 L -2.5709911,987.733 L 0.42528,986.0447 L 2.34877,983.08259 L 3.2190517,978.55516 L 2.7822762,967.2211 L 0.07537,952.3536 L 14.942868,949.64669 L 26.276921,949.20991 L 30.804348,950.0802 L 33.76645,952.0037 L 35.454722,954.99997 L 36.08215,958.07587 L 35.19004,964.39467 L 33.161245,970.81634 L 32.06689,977.1971 L 32.596644,980.52666 L 33.990789,983.06583 L 36.069667,984.92025 L 38.65362,986.19557 L 44.618121,987.43153 L 50.44703,987.6189 L 56.077091,987.35875 L 61.798339,986.10365 L 64.269561,984.83058 L 66.255264,982.98187 L 67.58601,980.44857 L 68.09236,977.1217 L 66.997997,970.74095 L 64.969202,964.31929 L 64.077097,958.00051 L 64.704528,954.92464 L 66.3928,951.9284 L 69.351661,950.00814 L 73.870548,949.14638 L 85.178694,949.60904 L 100.00851,952.3536 L 97.26391,967.2588 L 96.801222,978.61878 L 97.662966,983.15475 L 99.58322,986.1201 L 102.57949,987.80836 L 105.65539,988.43578 L 111.97419,987.54366 L 118.39584,985.51486 L 124.77656,984.4205 L 128.10342,984.92686 L 130.6367,986.25762 L 132.48537,988.24334 L 133.7584,990.71456 L 135.01349,996.4358 L 135.27378,1002.0658 L 135.08633,1007.8947 L 133.85037,1013.8592 L 132.57506,1016.4432 L 130.72065,1018.5221 L 128.18149,1019.9162 L 124.85193,1020.446 L 118.47121,1019.3515 L 112.04956,1017.3227 L 105.73077,1016.4307 L 102.65487,1017.0581 L 99.6586,1018.7464 L 97.735107,1021.7085 L 96.864823,1026.2359 L 97.301595,1037.57 L 100.0085,1052.4375 L 85.141004,1055.1444 L 73.806953,1055.5812 L 69.279529,1054.7109 L 66.31743,1052.7874 L 66.31743,1052.7874";
	String xmlEdgeIOI = "M 0.34991,1018.6711 L -2.6463611,1016.9828 L -5.7222606,1016.3554 L -12.041058,1017.2475 L -18.462706,1019.2763 L -24.84343,1020.3707 L -28.172991,1019.8409 L -30.712145,1018.4468 L -32.566548,1016.3679 L -33.841858,1013.7839 L -35.077817,1007.8194 L -35.26527,1001.9905 L -35.004995,996.36045 L -33.749909,990.63924 L -32.47687,988.16803 L -30.628199,986.18235 L -28.094917,984.85163 L -24.76805,984.3453 L -18.38733,985.43978 L -11.965683,987.46852 L -5.6468862,988.36054 L -2.5709882,987.73308 L 0.42528,986.0448 L 2.3455343,983.08596 L 3.2072794,978.56708 L 2.744595,967.25894 L 0,952.4291 L 99.93314,952.4291 L 97.22623,967.29659 L 96.789454,978.63062 L 97.659737,983.15802 L 99.58323,986.1201 L 102.5795,987.80839 L 105.6554,988.43584 L 111.97419,987.54375 L 118.39584,985.51496 L 124.77656,984.4206 L 128.10343,984.92696 L 130.6367,986.25771 L 132.48537,988.24341 L 133.75841,990.71462 L 135.01349,996.43585 L 135.27378,1002.0659 L 135.08633,1007.8948 L 133.85037,1013.8593 L 132.57506,1016.4433 L 130.72066,1018.5222 L 128.1815,1019.9163 L 124.85194,1020.4461 L 118.47122,1019.3516 L 112.04957,1017.3228 L 105.73077,1016.4308 L 102.65487,1017.0582 L 99.6586,1018.7465 L 97.73511,1021.7086 L 96.864828,1026.236 L 97.301604,1037.5701 L 100.00851,1052.4376 L 85.141013,1055.1445 L 73.806959,1055.5813 L 69.279532,1054.711 L 66.31743,1052.7875 L 64.629158,1049.7912 L 64.00173,1046.7153 L 64.89384,1040.3965 L 66.922635,1033.9749 L 68.01699,1027.5942 L 67.51064,1024.2673 L 66.179894,1021.7341 L 64.194191,1019.8854 L 61.722969,1018.6124 L 56.001721,1017.3573 L 50.37166,1017.097 L 44.542751,1017.2842 L 38.57825,1018.5202 L 35.994297,1019.7955 L 33.915419,1021.65 L 32.521274,1024.1892 L 31.99152,1027.5188 L 33.085883,1033.8995 L 35.114677,1040.3211 L 36.006783,1046.6399 L 35.379352,1049.7158 L 33.69108,1052.7121 L 30.72898,1054.6356 L 26.201555,1055.5059 L 14.867501,1055.0691 L 0,1052.3622 L 2.70691,1037.4947 L 3.1436859,1026.1606 L 2.2734029,1021.6332 L 0.34991,1018.6711 L 0.34991,1018.6711";
	String xmlEdgeOIO = "M 100.28305,1018.7464 L 97.286779,1017.0581 L 94.210879,1016.4307 L 87.892082,1017.3228 L 81.470434,1019.3515 L 75.08971,1020.4459 L 71.760149,1019.9162 L 69.220995,1018.522 L 67.366592,1016.4432 L 66.091283,1013.8592 L 64.855323,1007.8947 L 64.66787,1002.0658 L 64.928145,996.4357 L 66.183231,990.71444 L 67.45627,988.24322 L 69.304941,986.25751 L 71.838223,984.92676 L 75.16509,984.4204 L 81.54581,985.51489 L 87.967457,987.54367 L 94.286254,988.43572 L 97.362152,987.80827 L 100.35842,986.12 L 102.28191,983.15789 L 103.1522,978.63046 L 102.71542,967.2964 L 100.00852,952.4289 L 1e-5,952.3539 L -2.7068962,967.22135 L -3.1436717,978.55538 L -2.27339,983.0828 L -0.3499,986.0449 L 2.6463711,987.73316 L 5.7222706,988.36058 L 12.041068,987.46846 L 18.462716,985.43966 L 24.84344,984.3453 L 28.170303,984.85166 L 30.703579,986.18241 L 32.552245,988.16812 L 33.82528,990.63934 L 35.080366,996.3606 L 35.34066,1001.9907 L 35.153206,1007.8196 L 33.917246,1013.7841 L 32.641936,1016.3681 L 30.78753,1018.4469 L 28.248374,1019.8411 L 24.91881,1020.3708 L 18.53809,1019.2763 L 12.116443,1017.2475 L 5.7976462,1016.3555 L 2.7217482,1016.983 L -0.27452,1018.6713 L -2.2012523,1021.6334 L -3.0800756,1026.1608 L -2.669215,1037.4948 L 0,1052.3622 L 14.829816,1049.6553 L 26.137962,1049.2186 L 30.656849,1050.0888 L 33.61571,1052.0123 L 35.303982,1055.0086 L 35.931412,1058.0845 L 35.039305,1064.4033 L 33.010513,1070.825 L 31.91616,1077.2057 L 32.422507,1080.5326 L 33.75325,1083.0658 L 35.738951,1084.9145 L 38.210172,1086.1875 L 43.931419,1087.4426 L 49.56148,1087.7029 L 55.390389,1087.5157 L 61.35489,1086.2797 L 63.938843,1085.0043 L 66.017721,1083.1498 L 67.411866,1080.6106 L 67.94162,1077.281 L 66.847258,1070.9003 L 64.818467,1064.4787 L 63.926366,1058.1599 L 64.553797,1055.084 L 66.24207,1052.0877 L 69.204169,1050.1642 L 73.731593,1049.2939 L 85.065644,1049.7307 L 99.93314,1052.4376 L 102.64005,1037.5701 L 103.07683,1026.2361 L 102.20654,1021.7087 L 100.28305,1018.7466 L 100.28305,1018.7464";
	String xmlCorner ="M 33.69108,1052.7117 L 35.379352,1049.7154 L 36.00678,1046.6395 L 35.11467,1040.3207 L 33.085875,1033.8991 L 31.99152,1027.5184 L 32.521274,1024.1888 L 33.915419,1021.6496 L 35.994297,1019.7952 L 38.57825,1018.5199 L 44.542751,1017.284 L 50.37166,1017.0965 L 56.001721,1017.3566 L 61.722968,1018.6118 L 64.194189,1019.8848 L 66.17989,1021.7335 L 67.510633,1024.2668 L 68.01698,1027.5937 L 66.922618,1033.9744 L 64.893827,1040.3961 L 64.001726,1046.7149 L 64.629157,1049.7908 L 66.31743,1052.7871 L 69.27953,1054.7106 L 73.806956,1055.5808 L 85.141014,1055.1441 L 100.00852,1052.4372 L 97.301611,1037.5697 L 96.864836,1026.2356 L 97.73512,1021.7082 L 99.658615,1018.7461 L 102.65488,1017.0578 L 105.73078,1016.4304 L 112.04958,1017.3225 L 118.47123,1019.3513 L 124.85195,1020.4457 L 128.18151,1019.9159 L 130.72066,1018.5218 L 132.57507,1016.4429 L 133.85038,1013.8589 L 135.08634,1007.8944 L 135.27379,1002.0655 L 135.01352,996.43543 L 133.75843,990.71417 L 132.4854,988.24295 L 130.63673,986.25725 L 128.10345,984.92651 L 124.77658,984.42018 L 118.39586,985.51465 L 111.97421,987.5434 L 105.65541,988.43542 L 102.57951,987.80796 L 99.583235,986.11968 L 97.659744,983.15757 L 96.789461,978.63014 L 97.226237,967.29608 L 99.933145,952.42858 L 0,952.35358 L 0,1052.3622 L 14.867498,1055.0691 L 26.201551,1055.5058 L 30.728978,1054.6355 L 33.69108,1052.712 L 33.69108,1052.7117";

	Array<Piece> pieces = new Array<>();
	boolean drawGrid = true;

	public XMLPathTest (GameReset game) {
		super(game);
		clear.set(Color.GRAY);
		gameCamera.zoom = .25f;
		gameCamera.update();
//		pieces.add(new Piece("box", parsePath(xmlBox), 0f, 3f));
		pieces.add(new Piece("inner", parsePath(xmlInner), -4f, 0f));
		pieces.add(new Piece("edgeIOI", parsePath(xmlEdgeIOI), -2f, 0f));
		pieces.add(new Piece("edgeOIO", parsePath(xmlEdgeOIO), 0f, 0f));
		pieces.add(new Piece("corner", parsePath(xmlCorner), 2f, 0f));
	}

	protected static Array<Vector2> parsePath (String path) {
		Array<Vector2> points = new Array<>();
		char[] chars = path.toCharArray();
		char[] temp = new char[8 + 1 + 8];
		for (int i = 0; i < chars.length;) {
			char aChar = chars[i++];
			if (aChar == ' ') continue;
			if (aChar == 'M' || aChar == 'L') {
				// we have new point
				char next;
				int len = 0;
				while (i < chars.length) {
					next = chars[i++];
					if (next == ' ') continue;
					if (next == ',') {
						break;
					}
					temp[len++] = next;
				}
				float x = Float.parseFloat(new String(temp, 0, len));
				len = 0;
				while (i < chars.length) {
					next = chars[i++];
					if (next == ' ') {
						i--;
						break;
					}
					temp[len++] = next;
				}
				float y = Float.parseFloat(new String(temp, 0, len));
				// dunno wtf is up this this translate, needed to move y to 0
//				points.add(new Vector2(x * INV_SCALE, (y -952.36216f) * INV_SCALE));
				// -y + 100 to flip it
				points.add(new Vector2(x, (-y +952.36216f + 100)));
			} else if (aChar == 'Z') {
//				points.add(points.get(0).cpy());
			}
		}
		// BayazitDecomposer doesnt like duplicate points
		if (points.first().epsilonEquals(points.get(points.size -1), 0.001f)) {
			points.removeIndex(points.size -1);
		}
		IntArray remove = new IntArray();

		for (int i = 0; i < points.size; i++) {
			for (int j = 0; j < points.size; j++) {
				if (i == j) continue;
				Vector2 p1 = points.get(i);
				Vector2 p2 = points.get(j);
				if (p1.epsilonEquals(p2, .001f)) {
					if (!remove.contains(i) && !remove.contains(j))
						remove.add(i);
				}
			}
		}
		remove.sort();
		remove.reverse();
		for (int i = 0; i < remove.size; i++) {
			points.removeIndex(remove.get(i));
		}
		return points;
	}

	@Override public void render (float delta) {
		super.render(delta);
		enableBlending();
		renderer.setProjectionMatrix(gameCamera.combined);
		renderer.begin(ShapeRenderer.ShapeType.Line);
		if (drawGrid) {
			renderer.setColor(1, 1, 1, .25f);
			float sx = (int)(-VP_WIDTH/2);
			float sy = (int)(-VP_HEIGHT/2);
			int width = MathUtils.ceil(VP_WIDTH);
			int height = MathUtils.ceil(VP_HEIGHT);
			for (int x = 0; x <= width; x++) {
				renderer.line(sx + x, sy, sx + x, sy + height);
			}
			for (int y = 0; y <= height; y++) {
				renderer.line(sx, sy + y, sx + width, sy + y);
			}
		}

		for (Piece piece : pieces) {
			piece.draw(renderer);
		}

		renderer.end();
	}

	protected static class Piece {
		Vector2 pos = new Vector2();
		String name;
		Array<Vector2> rawPoints = new Array<>();
		Array<Array<Vector2>> rawPolygons = new Array<>();
		Color[] colors;
		Array<Polygon> polygons = new Array<>();

		public Piece (String name, Array<Vector2> rawPoints, float x, float y) {
			this.name = name;
			this.rawPoints.addAll(rawPoints);
			pos.set(x, y);

			rawPolygons = BayazitDecomposer.convexPartition(rawPoints);
			colors = new Color[rawPolygons.size];
			for (int i = 0; i < rawPolygons.size; i++) {
				colors[i] = new Color(MathUtils.random(), MathUtils.random(), MathUtils.random(), 1);
			}

			DelaunayTriangulator dt = new DelaunayTriangulator();
			for (Array<Vector2> rawPolygon : rawPolygons) {
				Polygon polygon = new Polygon();
				polygons.add(polygon);
				polygon.vertices = new float[rawPolygon.size * 2];
				for (int i = 0; i < rawPolygon.size; i++) {
					Vector2 p = rawPolygon.get(i);
					polygon.vertices[i * 2] = p.x;
					polygon.vertices[i * 2 + 1] = p.y;
				}
				polygon.indices = new ShortArray(dt.computeTriangles(polygon.vertices, false));
			}
		}

		float scale = .01f;
		float down = 2f;
		public void draw (ShapeRenderer renderer) {
			renderer.setColor(Color.CYAN);
			for (int i = 0; i < rawPoints.size -1; i++) {
				Vector2 p1 = rawPoints.get(i);
				Vector2 p2 = rawPoints.get(i + 1);
				renderer.line(pos.x + p1.x * scale, pos.y + p1.y * scale, pos.x + p2.x * scale, pos.y + p2.y * scale);
			}

//			for (int i = 0; i < rawPolygons.size; i++) {
//				renderer.setColor(colors[i]);
//				Array<Vector2> polygon = rawPolygons.get(i);
//				for (int j = 0; j < polygon.size - 1; j++) {
//					Vector2 p1 = polygon.get(j);
//					Vector2 p2 = polygon.get(j + 1);
//					renderer.line(pos.x + p1.x * scale, pos.y + p1.y * scale - down, pos.x + p2.x * scale, pos.y + p2.y * scale - down);
//					if (j == polygon.size -2) {
//						p1 = polygon.get(0);
//						renderer.line(pos.x + p1.x * scale, pos.y + p1.y * scale - down, pos.x + p2.x * scale, pos.y + p2.y * scale - down);
//					}
//				}
//			}

//			renderer.setColor(Color.GREEN);
//			for (Polygon polygon : polygons) {
//				float[] vertices = polygon.vertices;
//				for (int i = 0; i < vertices.length -2; i+=2) {
//					float x1 = vertices[i];
//					float y1 = vertices[i + 1];
//					float x2 = vertices[i + 2];
//					float y2 = vertices[i + 3];
//					renderer.line(pos.x + x1 * scale, pos.y + y1 * scale - down, pos.x + x2 * scale, pos.y + y2 * scale - down);
//				}
//				float x1 = vertices[0];
//				float y1 = vertices[1];
//				float x2 = vertices[vertices.length -2];
//				float y2 = vertices[vertices.length -1];
//				renderer.line(pos.x + x1 * scale, pos.y + y1 * scale - down, pos.x + x2 * scale, pos.y + y2 * scale - down);
//
//			}

			renderer.end();
			renderer.begin(ShapeRenderer.ShapeType.Filled);

			for (Polygon polygon : polygons) {
				float[] vertices = polygon.vertices;
				ShortArray indices = polygon.indices;
				for (int i = 0; i < indices.size; i+=3) {
					int i1 = indices.get(i) * 2;
					int i2 = indices.get(i + 1) * 2;
					int i3 = indices.get(i + 2) * 2;
					renderer.triangle(
						pos.x + vertices[i1] * scale, pos.y + vertices[i1 + 1] * scale - down,
						pos.x + vertices[i2] * scale, pos.y + vertices[i2 + 1] * scale - down,
						pos.x + vertices[i3] * scale, pos.y + vertices[i3 + 1] * scale - down
					);
				}
			}

			renderer.end();
			renderer.begin(ShapeRenderer.ShapeType.Line);
			renderer.setColor(Color.MAGENTA);
			for (int i = 0; i < rawPolygons.size; i++) {
				Array<Vector2> polygon = rawPolygons.get(i);
				for (int j = 0; j < polygon.size - 1; j++) {
					Vector2 p1 = polygon.get(j);
					Vector2 p2 = polygon.get(j + 1);
					renderer.line(pos.x + p1.x * scale, pos.y + p1.y * scale - down, pos.x + p2.x * scale, pos.y + p2.y * scale - down);
					if (j == polygon.size -2) {
						p1 = polygon.get(0);
						renderer.line(pos.x + p1.x * scale, pos.y + p1.y * scale - down, pos.x + p2.x * scale, pos.y + p2.y * scale - down);
					}
				}
			}
		}

		static class Polygon {
			public float[] vertices;
			public ShortArray indices;
		}
	}

	private void draw (Array<Vector2> points, float ox, float oy) {
		for (int i = 0; i < points.size -1; i++) {
			Vector2 p1 = points.get(i);
			Vector2 p2 = points.get(i + 1);
			renderer.line(p1.x + ox, p1.y + oy, p2.x + ox, p2.y + oy);
		}
	}

	// allow us to start this test directly
	public static void main (String[] args) {
		PlaygroundGame.start(args, XMLPathTest.class);
	}
}
