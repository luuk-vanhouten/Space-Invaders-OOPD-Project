module waterworld {
    requires hanyaeger;
    requires com.google.guice;

    exports com.github.hanyaeger.tutorial;

    opens audio;
    opens backgrounds;
    opens sprites;
}
