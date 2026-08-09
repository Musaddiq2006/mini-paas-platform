function handleUpload(){
    const projectName = document.getElementById("projectName").value;
    const zipFile = document.getElementById("zipFile");
    if(projectName==NaN){
        alert("Please Enter a project Name!");
        return;
    }
    if(fileInput.files.length ===0){
        alert("Please upload a zip file!");
        return;
    }
    const fileName = fileInput.files[0].name;
    alert("Project: "+ projectName+ " with file: "+ fileName+ " ready for deployment");

}