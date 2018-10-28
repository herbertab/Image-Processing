package pseimage;

import java.util.List;

/**
 * O filtro logarítmico reduz o contraste da imagem em áreas de alta intensidade
 * e aumenta o contraste em áreas de baixa intensidade. 
 * A função recebe 2 argumentos, sendo o primeiro argumento o nome da imagem a 
 * ser processada e o segundo argumento uma constante C utilizada no cálculo.
 * Uma nova imagem será armazenada no disco com a identificação "logarithmic" e o 
 * nome desse arquivo é retornado pela função. 
 */
public class Logarithmic extends Filter implements Filterable{
    
    @Override
    public String filter(List<String> params) {
        
        this.openImage(params.get(0));
        this.setFilteredImageName("logarithmic");        
        int c = Integer.parseInt(params.get(1));
        
        //c = 40;
                
        for(int x=0; x<image.getWidth(); x++){
            for(int y=0; y<image.getHeight(); y++){
                int pixel = image.getRGB(x, y);
                Pixel p = new Pixel(pixel);
                double k = 1.0 + (double)p.gray;
                
                double log = Math.log(k);                
                //System.out.println(log);
                int value = (int) (c * log); 
                value = Math.min(255, Math.max(0, value));
                p.setRGB(value, value, value);  
                image.setRGB(x, y, p.getComposedPixel());
            }
        }
        
        this.storeImage();
        return filteredImage;
    }
    
}
