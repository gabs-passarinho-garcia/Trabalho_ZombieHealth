package zumbi.Classes.ContaSuperFactory;

import zumbi.Interfaces.IContaFactory.*;
import zumbi.Classes.MelhorFactory.*;

public class ContaSuperFactory {
	public static IContaFactory criaFabrica() {
		return new MelhorFactory();
	}
}
