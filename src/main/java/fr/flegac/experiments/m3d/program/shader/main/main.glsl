uniform float time;

uniform Algorithms {
	bool USE_LIGHT;
	bool USE_SHADOW;
	bool USE_NORMALMAP;
} algorithms;

attribute Vertex {
	vec3 position;
	vec3 normal;
	vec2 texture;
} vertex;
