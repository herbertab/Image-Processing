package pseimage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *
 * @author Herbert
 */
public class PSEImage {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {      
        
        String n = "img.jpeg";
      
        String[] args2 = {n, "3", "3", "lowpass", "1", "1", "1", "1", "1", "1", "1", "1", "1"};
        
        List<String> params = new ArrayList<>();        
        
        params.addAll(Arrays.asList(args2));        
        
        Filter.toGray(params.get(0));
        new GenericMask().filter(params);        
        new HistogramEqualization().filter(params);
        new DigitalNegative().filter(params);
        new Laplace().filter(params);
        new Median().filter(params);
        new Min().filter(params);
        new Max().filter(params);
        
        params.set(1, "35");
        new Logarithmic().filter(params);
        
        params.set(1, "2");
        params.set(2, "0.8");
        new Potency().filter(params);
        
        params.set(1, "150");        
        new Tresholding().filter(params);
        
        params.set(1, "7");
        new Gaussian().filter(params);        
        
        params.set(1, "laplace_mask 3x3_"+n);
        new SumImage().filter(params);
        new SubtractImage().filter(params);
              
        int[] h = Filter.getHistogram(n);
        /*for(int i : h){
            System.out.println(i);
        }*/
        
        Filter.plotHistogram(h, params.get(0));
        Filter.plotFDP(h, params.get(0));
        Filter.plotfdp(h, params.get(0));
        
        double mse = Filter.MSE(params.get(0), params.get(1));
        System.out.println("Erro médio quadrático = "+mse);     
        
        double mseH = Filter.MSE(Filter.getHistogram(params.get(0)), Filter.getHistogram(params.get(1)));
        System.out.println("Erro médio quadrático H = "+mseH);   
        
        double psnr = Filter.PSNR(params.get(0), params.get(1));
        System.out.println("Pico Relação Sinal Ruído = "+psnr);
        
        //params.set(1, "2");
        //new KMeans().filter(params);
        
        new SimpleGlobalTresholding().filter(params);
    }    
    
}
