void main(void) {
	if( algorithms.USE_LIGHT ) {
		lightAlgorithm();
	}
	if( algorithms.USE_SHADOW ) {
		shadowAlgorithm();
	}
	if( algorithms.USE_NORMALMAP ) {
		normalmapAlgorithm();
	}

	cameraAlgorithm();
	textureAlgorithm();
}