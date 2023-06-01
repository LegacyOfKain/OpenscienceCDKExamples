import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

import org.openscience.cdk.DefaultChemObjectBuilder;
import org.openscience.cdk.depict.Depiction;
import org.openscience.cdk.depict.DepictionGenerator;
import org.openscience.cdk.interfaces.IAtom;
import org.openscience.cdk.interfaces.IAtomContainer;
import org.openscience.cdk.io.MDLV2000Reader;
import org.openscience.cdk.silent.Atom;
import org.openscience.cdk.silent.AtomContainer;
import org.openscience.cdk.smiles.SmilesGenerator;
import org.openscience.cdk.smiles.SmilesParser;

public class TestMolandSMItoPNG {

	public static void main(String args[]) throws Exception {
        IAtom atom = new Atom("C");
        System.out.println(atom);
        
        DepictionGenerator dg = new DepictionGenerator()
        		.withSize(512, 512)
                .withAtomColors();
        
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("BS23007520026_problematic.mol");
         
        MDLV2000Reader reader = new MDLV2000Reader(is);
        IAtomContainer mol = reader.read(new AtomContainer());
        Depiction depiction = dg.depict(mol);
        BufferedImage img = depiction.toImg();
        File outputfile = new File("C:/temp/mol.png");
        ImageIO.write(img, "png", outputfile);
        
        String smiles = SmilesGenerator.unique().create(mol);
        
        SmilesParser p = new SmilesParser(DefaultChemObjectBuilder.getInstance());       
        IAtomContainer mol2 =  p.parseSmiles(smiles);
        Depiction depiction2 = dg.depict(mol2);
        BufferedImage img2 = depiction2.toImg();
        File outputfile2 = new File("C:/temp/mol2.png");
        ImageIO.write(img2, "png", outputfile2);
        
    }
}