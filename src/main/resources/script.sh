mkdir my-shell-folder
cd my-shell-folder || exit
touch my-shell-file.txt
echo 'Hallo Welt!' >> my-shell-file.txt
cat my-shell-file.txt
cd ..
rm -R my-shell-folder
