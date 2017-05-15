This project is used in a StackOverflow question. It is about Android data binding of a spinner with a BaseAdapter.

Steps to reproduce:
- Compile and Start
- Open Spinner
- Selection contains the first element (unnamed plane and distance 0), twice.
- One planet from the original list is missing.

Explanation

The BaseAdapter is necessary here, because there are two views in the spinner list items instead of one. 
ArrayAdapter is of no use here,  because it requires a single TextView, to do its adapting. 

I use two TextViews here. (In case you want to merge the TextViews into one to make ArrayAdapter work, imagine, the second TextView is an ImageView. :))

In its current state the Spinner uses PlanetAdapter, extending BaseAdapter. This tries to bind the Spinner items via Android Data Binding. 
The problem is, that the first item of the planets is twice in the list, and one planet is missing. Selecting a planet does work, but <b>the drop down
list of the spinner, always contains the first element twice and the selected element is not visible there</b>.

This project is based on chrislizh's project demonstrating Androids two-way databinding with a Spinner for the selected element. 
(https://github.com/chrislizh/SpinnerTwoWayDataBindingDemo).

I only changed the ArrayAdapter, which also affected some methods in BindingPlanet. 

Technically the binding regarding the selected planet works fine. To verify this I implemented a classic 
implementation of the BaseAdapter using no DataBinding (findViewById and ViewHolder pattern). 

The sample code for the classic case is also in the PlanetAdapter, at the end of the file, but commented out, in case you want to see, just switch
getView und PlaneViewHolderimplementations there.

What's wrong with my Binding implementation of the BaseAdapter? 