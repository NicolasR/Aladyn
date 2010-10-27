package fr.upmc.aladyn.dyn_generics.transform;

import java.awt.Point;

public class Test {
	public void ma_methode() { // On regarde le temps au départ
		long time = System.currentTimeMillis();
		// le corps de ma méthode
		int res = 0;
		for (int i = 0; i < 30000; i++) {
			Point p = new Point(i, i);
			res += p.x + p.y;
		}
		// Récupération du résultat
		System.out.println("Temps passé dans ma_methode :"
				+ (System.currentTimeMillis() - time));
	}
}
