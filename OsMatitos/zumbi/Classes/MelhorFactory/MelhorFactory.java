package zumbi.Classes.MelhorFactory;

import zumbi.Componentes.ContaMetade;
import zumbi.Interfaces.IContaFactory.*;
import zumbi.Interfaces.IContador.*;

public class MelhorFactory implements IContaFactory  {
	public IContador criaMelhorPergunta(){
		return new ContaMetade();
	}
}
