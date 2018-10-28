package pseimage;

import java.util.List;

/**
 * A equalização de histograma é utilizada para estender o contraste da imagem.
 * Basicamente ela redistribui as intensidades da imagem fazendo com que ocupem 
 * o espectro de intensidades de maneira mais uniforme.
 * A função recebe um único argumento que indica o nome da imagem a ser processada.
 * Uma nova imagem será armazenada no disco com a identificação "histogramEq" e o 
 * nome desse arquivo é retornado pela função. 
 */
public class HistogramEqualization extends Filter implements Filterable{
    public static final int NUM_COLORS = 256;    
    
    @Override
    public String filter(List<String> params) {
        
        this.openImage(params.get(0));
        this.setFilteredImageName("histogramEq");
        
        int[] histogram = new int[NUM_COLORS];
        int[] equalized = new int[NUM_COLORS];
        double[] probabilities = new double[NUM_COLORS];
        int numPixels = image.getWidth()*image.getHeight();
        
        for(int x=0; x<NUM_COLORS; x++){
            histogram[x] = 0;
            equalized[x] = 0;
            probabilities[x] = 0.0;
        }
        
        for(int i=0; i<image.getWidth(); i++){
            for(int j=0; j< image.getHeight(); j++){                
                int p = image.getRGB(i, j);
                Pixel pixel = new Pixel(p);
                histogram[pixel.gray]++;                
            }
        }
        
        probabilities[0] = (double)histogram[0] / (double)numPixels;
        for(int x=1; x<NUM_COLORS; x++){
            probabilities[x] = ((double)histogram[x] / (double)numPixels) + probabilities[x-1];
            //System.out.println(probabilities[x]);
        }
        
        double vMin = probabilities[0];
        double vMax = 1.0 - probabilities[0];
        
        for(int x=0; x<NUM_COLORS; x++){
            equalized[x] = (int)((((probabilities[x] - vMin) / vMax) * (double)(NUM_COLORS-1)) + 0.5);
            //System.out.println(equalized[x]);
        }
        
        for(int i=0; i<image.getWidth(); i++){
            for(int j=0; j< image.getHeight(); j++){                
                int p = image.getRGB(i, j);
                Pixel pixel = new Pixel(p);
                int index = pixel.gray;
                int eq = equalized[index];
                pixel.setRGB(eq, eq, eq);
                image.setRGB(i, j, pixel.getComposedPixel());
            }
        }
        
        this.storeImage();
        return filteredImage;
    }
    
}
