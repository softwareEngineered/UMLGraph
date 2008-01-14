package org.umlgraph.engine;

import org.umlgraph.engine.matching.AnyMatcher;
import org.umlgraph.engine.matching.ElementMatcher;
import org.umlgraph.settings.Settings;

/**
 * Represents a diagram by selecting a set of elements that should be depicted,
 * and defining how those elements are shown.
 * 
 * Includes:
 * <ul>
 * <li>a view, which determines <em>which</em> elements from a model will be
 * depicted
 * <li>layout settings, which affect <em>how</em> the selected elements
 * should be depicted (colors, font faces, font sizes, etc)</li>
 * </ul>
 */
public abstract class Diagram {
    private String rootNamespace;
    private ElementMatcher elementMatcher;
    private Settings layoutSettings;

    public Diagram(String rootNamespace, ElementMatcher matcher) {
        this.rootNamespace = rootNamespace;
        this.elementMatcher = matcher == null ? AnyMatcher.INSTANCE : matcher;
        this.layoutSettings = createSettings();
    }

    protected abstract Settings createSettings();

    public Settings getLayoutSettings() {
        return layoutSettings;
    }

    public String getRootNamespace() {
        return rootNamespace;
    }

    public ElementMatcher getElementMatcher() {
        return elementMatcher;
    }
}