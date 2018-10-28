package pseimage;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Este filtro recebe 2 imagens como parâmetro e gera uma terceira imagem com os
 * valores, pixel a pixel, equivalentes a imagem1 + imagem2. 
 * Esta terceira imagem é armazenada e a função retorna o nome do arquivo.
 */
public class SumImage extends Filter implements Filterable {

    @Override
    public String filter(List<String> params) {
        
        BufferedImage img1 = this.openImage(params.get(0));
        BufferedImage img2 = this.openImage(params.get(1));
        this.setFilteredImageName("sum "+params.get(1));
        
        for(int i=0; i<img1.getWidth(); i++){
            for(int j=0; j<img1.getHeight(); j++){
                
                int v1 = img1.getRGB(i, j);
                Pixel im1 = new Pixel(v1);
                int v2 = img2.getRGB(i, j);
                Pixel im2 = new Pixel(v2);
                
                int sum = im1.gray + im2.gray; 
                sum = Math.min(255, Math.max(0, sum));
                im2.setRGB(sum, sum, sum);                
                img2.setRGB(i, j, im2.getComposedPixel());
                
            }
        }
        
        this.storeImage(this.filteredImage, img2);
        return filteredImage;
    }
    
}
