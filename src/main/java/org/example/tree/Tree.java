package org.example.tree;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class Tree {
    private TreeParts parts;
    private AdvancedSpecification specification;

    private boolean hasAllParts(){
        return parts != null && parts.getTrunk() != null && parts.getRoots() != null && parts.getBranch() != null;
    }
}
