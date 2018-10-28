package pseimage;

import java.util.List;

/**
 * O filtro negativo converte uma imagem no seu complemento.
 * Cada pixel da imagem é transformado no valor que falta para que o mesmo tenha 
 * valor máximo. 
 * A função recebe como entrada uma lista de parâmetros, mas só irá ler o primeiro 
 * argumento que deve ser o endereço da imagem a ser convertida.
 * Uma nova imagem será armazenada no disco com a identificação "negative" e o 
 * nome desse arquivo é retornado pela função. 
 */
public class DigitalNegative extends Filter implements Filterable{
    
    @Override    
    public String filter(List<String> params) {         
        
        this.openImage(params.get(0));
        this.setFilteredImageName("negative");        
              
        for(int x=0; x<image.getWidth(); x++){
            for(int y=0; y<image.getHeight(); y++){
                int pixel = image.getRGB(x, y);
                Pixel p = new Pixel(pixel);  
                int value = 255 - p.gray;
                p.setRGB(value, value, value);  
                image.setRGB(x, y, p.getComposedPixel());
            }
        }        
        this.storeImage();
        return filteredImage;
    }   
}