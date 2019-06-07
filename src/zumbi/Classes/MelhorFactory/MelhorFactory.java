package zumbi.Classes.MelhorFactory;

import zumbi.Interfaces.IContaFactory.*;
import zumbi.Interfaces.IContador.*;
import zumbi.Classes.ContaMetade.*;

public class MelhorFactory implements IContaFactory  {
	public IContador criaMelhorPergunta(){
		return new ContaMetade();
	}
}
