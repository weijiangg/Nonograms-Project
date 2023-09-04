# Nonograms-Project

I used the model-view-controller design pattern together with the JavaFX UI library to design a complete, functioning GUI implementation of the single-player logic puzzle nonograms.

For my implementation, the app, has the following features:

1. If the user left-clicks on a cell, that cell becomes shaded. But, if they right-click on a cell, that cell becomes eliminated. There is visual difference between a shaded and an eliminated cell. A cell cannot be both shaded and eliminated. Cells are clearly marked, so the user can tell which cell they are selecting.

![Rules 1](https://user-images.githubusercontent.com/69730095/189803422-a5065fcb-a6cd-4f3d-8808-50611adfd178.png)

2. If the user left-clicks on an already-shaded cell, that cell returns to a blank state. If the user right-clicks on an already-eliminated cell, that cell returns to a blank state.

3. After each move, the app checks to see if the user solved the puzzle. If so, the UI visually updates to let the user know that they completed the puzzle. The puzzle is "solved" if the shaded squares match the clues. Non-shaded squares do not need to be labeled "eliminated" in order to solve the puzzle.

![Rules 3-2](https://user-images.githubusercontent.com/69730095/189803717-4ad56d20-d65a-43cd-8c51-d02f3918c04e.png) ![Rules 3](https://user-images.githubusercontent.com/69730095/189804053-b99fa9f0-3d24-4561-bff2-a320a706ca9f.png)


4. The UI includes a clearly visible and labeled "reset" button that will clear all the cells in the board and let the user start over from a blank state.

![Rule 4](https://user-images.githubusercontent.com/69730095/189804529-1d36a3ba-6ab8-419f-856b-76c211966f6f.png)

5. The UI provides clearly visible and labeled buttons to go to the next puzzle, to go to the previous puzzle, and to jump to a random puzzle. 

![Rule 5](https://user-images.githubusercontent.com/69730095/189804540-1f439bcd-fe5e-4d9f-b6d4-46dda7055ed0.png)

6. The app clearly displays the index of the active puzzle in the library and how many puzzles are in the library in total. 

7. The app supports arbitrary-sized boards with different widths and heights.

These are the 5 nonograms puzzles solved:

![1-5 solved](https://user-images.githubusercontent.com/69730095/189802861-3b326493-48e2-4dd4-8a1a-baafb1da361b.png)
![2-5 sloved](https://user-images.githubusercontent.com/69730095/189802952-38bc1961-68a7-4e39-9f2e-392c53635f52.png)
![3-5 solved](https://user-images.githubusercontent.com/69730095/189803017-c9c76eeb-0055-458a-a8ae-3042f80ad0fb.png)
![4-5 solved](https://user-images.githubusercontent.com/69730095/189803041-db18a8ca-a738-40e4-8f07-f8fb436279ed.png)
![5-5 solved](https://user-images.githubusercontent.com/69730095/189803047-75257c73-7362-4407-92f9-254998474ad9.png)
