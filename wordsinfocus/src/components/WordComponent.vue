<template>
</template>
<script>
    export default{
        name: "WordComponent",
        props:['wordId'],
        data() {
            return {
                id: wordId
            }
        },
        methods: {
            async getWords(){
                const lettersApi = await fetch('http://localhost:9090/api/letters/' + this.letter.id + '/words')
                const result = await lettersApi.json();
                this.words = result;
            }
        },
        computed: {
          
        },
        beforeMount(){
            this.getWord();
        }
    }
</script>

<style scoped>
.container {
    height: 80vh;
}

.letter{
    background-color: whitesmoke;
    display: inline-block;
    width: 80px;
    padding: 50px;
    margin-top: 98px;
    font-size:xx-large;
    font-family: cursive;
    font-size: 50px;
    color: #89621c;
    box-shadow: 5px 5px 10px 0px;;
    border-bottom: 1px solid #bb8a36;
    border-radius: 30px;
}
.left {

  display: block;
  float: left;
  width: 30%;
  height: 100%;
}

.right {
    display: block;
  /* background-color: #22a30b; */
  float: left;
  width: 70%;
  height: 100%;
}

.top{
    height: 50%;
    width: 100%;
    
}

.bottom{
    height: 50%;
    /* background-color: pink; */
}

.words{
    width: 30%;
    display: block;
}

</style>