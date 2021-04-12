#Control Your Crowd - Documentation

## Maintaining Documentation
We use [Jekyll](https://jekyllrb.com/) to manage documentation. 
To learn how to set it up and maintain the project website, follow the guide 
[[se-edu/guides] Using Jekyll for project documentation](https://se-education.org/guides/tutorials/jekyll.html).

## Style Guidance
* Follow the [Google developer documentation style guide](https://developers.google.com/style)
* Also relevant is the [[se-edu/guides] Markdown coding standard](https://se-education.org/guides/conventions/markdown.html)

## Editing Diagrams
We used [Creately](https://creately.com/) to create UML diagrams for the developer guide.
> Note: Although Creately is not a completely free software, the free version provides the necessary functionalities needed
> create diagrams for the developer guide. We chose Creately over other diagram tools such as PlantUML because 
> it is easier to use. The workspace can also be easily shared among team members through email where the entire team
> can edit the diagram together.

## Converting Documentation to PDF format
We use [Google Chrome](https://www.google.com/chrome/) for converting documentation to PDF format.
> **Reason**: Chrome's PDF engine preserves hyperlinks used in Web pages.

Here are the steps to convert the project documentation files to PDF format.
1. Go to your generated documentation site on GitHub using Chrome.
2. Within Chrome, click on the `Print` option in Chrome's menu.
3. Set the destination to `Save as PDF`, then click `Save` to save a copy of the file in PDF format.
For best results, use the settings indicated in the screenshot below.

![img.png](images/chrome_save_as_pdf.png)

> #### Adding a page break manually
> In some cases, you might want to force a page break at certain point in the generated PDF file.
> In those case, you can do so by inserting the following into the corresponding place in your source file.
> 
> `<div style="page-break-after: always;"></div>`
