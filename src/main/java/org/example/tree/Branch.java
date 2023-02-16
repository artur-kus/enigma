package org.example.tree;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Branch {
    private Leaf leaf;
    private Branch branch;

    private boolean hasLeaf() {
        return leaf != null;
    }
}
