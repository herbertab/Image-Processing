package pseimage;

import java.util.List;

/**
 * Limiariza a imagem dividindo seus pixels em 2 grupos.
 * O critério para escolha do grupo é o Limiar que é recebido como parâmetro pela
 * função. A imagem binária é armazenada e seu nome é retornado pela função. 
 */
public class Tresholding extends Filter implements Filterable {

    @Override
    public String filter(List<String> params) {
        
        this.openImage(params.get(0));
        this.setFilteredImageName("tresholding");
        
        int t = Integer.parseInt(params.get(1));
        //int color1 = Integer.parseInt(params.get(2));
        //int color2 = Integer.parseInt(params.get(3));
        
        for(int i=0; i<image.getWidth(); i++){
            for(int j=0; j<image.getHeight(); j++){
                Pixel n = new Pixel(image.getRGB(i, j));
                    int v = (n.gray > t) ? 255 : 0;
                    n.setRGB(v, v, v);
                    image.setRGB(i, j, n.getComposedPixel());                
            }
        }
        
        this.storeImage();
        return filteredImage;
    }
    
}
