package org.example.tree;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Leaf {
    private Leaf leaf;
    private Branch branch;
}
