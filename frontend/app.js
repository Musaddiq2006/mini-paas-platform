function handleUpload(){
    const projectName = document.getElementById("projectName").value;
    const zipFile = document.getElementById("zipFile");
    if(projectName.trim()==""){
        alert("Please Enter a project Name!");
        return;
    }
    if(zipFile.files.length ===0){
        alert("Please upload a zip file!");
        return;
    }
    const fileName = zipFile.files[0].name;
    alert("Project: "+ projectName+ " with file: "+ fileName+ " ready for deployment");

}
function unlockEvaluator(){
    const pinInput= document.getElementById("evaluatorPin").value;
    const overlay = document.getElementById("modalOverlay");
    if(pinInput==="1234"){
        overlay.style.display="none";
        alert("Permission Granted!");
        
    }
    else{
        alert("Incorrect PIN! Try Again")
    }
}