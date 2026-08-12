async function handleUpload(event){

    if(event) event.preventDefault();

    const projectName = document.getElementById("projectName").value;
    const zipFile = document.getElementById("zipFile");
    const techStackSelect = document.getElementById("techStack");

    if(projectName.trim()===""){
        alert("Please Enter a project Name!");
        return;
    }
    if(zipFile.files.length ===0){
        alert("Please upload a zip file!");
        return;
    }
   
    const techStackValue = techStackSelect.value;
    const fileSelected = zipFile.files[0];
    const formData= new FormData;
    formData.append("projectName",projectName);
    formData.append("techStack",techStack);
    formData.append("file",fileSelected);

    try{
        const response = await fetch("http://localhost:5050/api/deploy", {
            method: "POST",
            body: formData
        });
        const data = await response.json();
        if(response.ok && data.status==="SUCCESS"){
            alert(`${data.message}\nAssigned Port: ${data.assignedPort}`);
        }
        else{
            alert(" Failed to process upload.")
        }
    }
    catch(error)
    {
        console.error("Network Error!");
    }
}
function unlockEvaluator(){
    const pinInput= document.getElementById("evaluatorPin").value;
    const overlay = document.getElementById("modalOverlay");/*dims bg*/
    if(pinInput==="1234"){
        overlay.style.display="none";
        alert("Permission Granted!");  
    }
    else{
        alert("Incorrect PIN! Try Again")
    }
}