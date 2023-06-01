package Msg;

import org.openscience.cdk.DefaultChemObjectBuilder;
import org.openscience.cdk.interfaces.IAtomContainer;
import org.openscience.cdk.smiles.SmilesParser;
import org.openscience.cdk.tools.manipulator.AtomContainerManipulator;

public class CsharpClass {
	
	public static void WelcomeMsg(String msg) {
		   
	       System.out.println("Welcome"+msg);
	              
	   }
	   
	  public static void GoodByeMsg(String msg) {
	   
	       System.out.println("Good Bye"+msg);
	              
	   }
	  
	  public static void SmilesToMass(String smiles)
	  {
		  SmilesParser p = new SmilesParser(DefaultChemObjectBuilder.getInstance());       
	      try {
			IAtomContainer mol2 =  p.parseSmiles(smiles);
			System.out.println(AtomContainerManipulator.getMass(mol2));
		} catch (Exception e) {
			e.printStackTrace();
		}
	  }
}
