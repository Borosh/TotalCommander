public class Main {
	private static FajlLista balLista = new FajlLista(new File("D:\\"));

	public static void main(String[] args) throws Exception {
		Navigacio.belelep(new File("D:\\Gitar iskola"), balLista);
		for (File i : balLista.lista) {
			FajlAdatok.getAdatok(i, balLista);
		}

		try {
			Operaciok.ujMappa(Paths.get(balLista.helyzet.getAbsolutePath() + "\\mappa1"));
			Navigacio.belelep(new File("D:\\Gitar iskola\\mappa1"), balLista);
			Operaciok.ujMappa(Paths.get(balLista.helyzet.getAbsolutePath() + "\\mappa2"));
			Navigacio.belelep(new File("D:\\Gitar iskola"), balLista);
			Operaciok.torol(Paths.get(balLista.helyzet.getAbsolutePath() + "\\mappa1"));
			Navigacio.interakcio(new File("D:\\Gitar iskola\\valami.valami.txt"), balLista);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Hiba", JOptionPane.ERROR_MESSAGE);
		}
	}
}
