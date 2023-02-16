package org.example.tree;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Trunk {
    private Float circuit;
    private Dimension dimension;
    private Long countOfBarkBeetles;

    private boolean isTreeHealthy(){
        return countOfBarkBeetles == null || countOfBarkBeetles == 0;
    }
}
