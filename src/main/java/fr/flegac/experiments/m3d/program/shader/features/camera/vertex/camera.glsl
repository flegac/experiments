void cameraAlgorithm(void) {
	gl_Position = vertex.position * camera.modelView * camera.projection;
}