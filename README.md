This project is used in a StackOverflow question. It is about Android data binding of a spinner with a BaseAdapter.

The BaseAdapter is necessary here, because there are two views in the spinner list items instead of one. 
ArrayAdapter is of no use here,  because it requires a single TextView, to do its adapting. 

I use two TextViews here. (In case you want to merge the TextViews into one to make ArrayAdapter work, imagine, the second TextView is an ImageView. :))

In its current state the Spinner uses PlanetAdapter, extending BaseAdapter. This tries to bind the Spinner items via Android Data Binding. 
The problem is, that the first item of the planets is twice in the list, and one planet is missing. Selecting a planet does work, but the drop down
list of the spinner, always contains the first element twice and the selected element is not visible there.

This project is based on chrislizh's project demonstrating two-way databinding with a spinner for the selected element. 
(https://github.com/chrislizh/SpinnerTwoWayDataBindingDemo)I only changed the ArrayAdapter, which also affected some methods in BindingPlanet. 
Technically the binding regarding the selected planet works fine, I tried a classic BaseAdapter using no DataBinding (using findViewById and ViewHolder). 
The sample code for the classic case is also in the PlanetAdapter, at the end of the file, but commented out, in case you want to see, just switch
getView und PlaneViewHolderimplementations there.

