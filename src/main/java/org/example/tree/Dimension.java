package org.example.tree;

import com.sun.jdi.InternalException;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.helper.GeneralUtil;

@Data
@NoArgsConstructor
public class Dimension {
    private Float height;
    private Float width;
    private Float thickness;
    private Float weight;

    private boolean hasAllDimensions(){
        return !GeneralUtil.isNullOrZero(height) && !GeneralUtil.isNullOrZero(width) && !GeneralUtil.isNullOrZero(thickness);
    }

    private Float getM3Volume(){
        if (!hasAllDimensions()) throw new InternalException("One of dimension is not exist");
        return height * width * thickness;
    }
}
